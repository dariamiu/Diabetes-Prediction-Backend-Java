package diabtes_predication.service;

import diabtes_predication.model.dto.ChangePasswordDto;
import diabtes_predication.model.dto.JwtResponseDto;
import diabtes_predication.exception.UserException;
import diabtes_predication.model.User;
import diabtes_predication.model.dto.UserDto;
import diabtes_predication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static diabtes_predication.service.JwtService.getUserIdFromSecurityContext;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserByIdFromContext() {
        return userRepository.findById(getUserIdFromSecurityContext()).orElseThrow(() -> new UserException(""));
    }

    public JwtResponseDto registerUser(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();

        if (userRepository.existsByUsername(user.getUsername()))
            throw new UserException("An account with this username already exists.");

        if (userRepository.existsByEmail(user.getEmail()))
            throw new UserException("An account with this email address already exists.");

        userRepository.save(user);
        return loginUser(userDto);
    }

    public JwtResponseDto loginUser(UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateJwt(authentication);

        return new JwtResponseDto(jwt);
    }

    public void changePassword(ChangePasswordDto changePasswordDto) {
        User user = getUserByIdFromContext();

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), changePasswordDto.getOldPassword()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException("The old password is wrong.");
        }

        user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
        userRepository.save(user);
    }

    public void deleteUser() {
        userRepository.delete(getUserByIdFromContext());
    }
}
