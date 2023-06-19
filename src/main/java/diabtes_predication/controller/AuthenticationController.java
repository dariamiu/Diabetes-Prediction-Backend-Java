package diabtes_predication.controller;

import diabtes_predication.model.dto.ChangePasswordDto;
import diabtes_predication.model.dto.JwtResponseDto;
import diabtes_predication.model.dto.UserDto;
import diabtes_predication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<JwtResponseDto> register(@Validated @RequestBody UserDto userDTO)
    {
        return ResponseEntity.ok(userService.registerUser(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@Validated @RequestBody UserDto userDTO) {
        return ResponseEntity.ok(userService.loginUser(userDTO));
    }

    @PostMapping("/reset-password")
    public void resetPassword(@RequestBody ChangePasswordDto passwordDto){
        userService.changePassword(passwordDto);
    }

    @DeleteMapping("/delete")
    public void deleteUser()
    {
        userService.deleteUser();
    }
}
