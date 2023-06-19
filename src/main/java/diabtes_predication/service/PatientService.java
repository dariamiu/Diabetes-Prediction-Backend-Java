package diabtes_predication.service;

import diabtes_predication.model.Patient;
import diabtes_predication.model.dto.ObjectDtoBuilder;
import diabtes_predication.model.dto.PatientDto;
import diabtes_predication.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;


    public HashMap<String,Object> addPatient(PatientDto patientDto){

        HashMap<String, Object> response = new HashMap<String, Object>();

        try{
            ObjectDtoBuilder objectDTOBuilder = new ObjectDtoBuilder();
            Patient patient= objectDTOBuilder.patientDtoToEntity(patientDto);
            patientRepository.save(patient);

            response.put("message", "Patient added!");
            response.put("success", true);
            return response;

        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success",false);
            return response;
        }
    }
}
