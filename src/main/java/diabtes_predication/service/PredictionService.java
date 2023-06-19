package diabtes_predication.service;

import diabtes_predication.model.Patient;
import diabtes_predication.model.Prediction;
import diabtes_predication.model.dto.ObjectDtoBuilder;
import diabtes_predication.model.dto.PredictionDto;
import diabtes_predication.repository.PatientRepository;
import diabtes_predication.repository.PredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PredictionService {

    @Autowired
    PredictionRepository predictionRepository;

    @Autowired
    PatientRepository patientRepository;


    public HashMap<String, Object> predict(PredictionDto predictionDto){
        HashMap<String, Object> response = new HashMap<String, Object>();

        try{
            ObjectDtoBuilder objectDTOBuilder = new ObjectDtoBuilder();
            Patient patient = patientRepository.findPatientByMyId(predictionDto.getPatientId());
            Prediction prediction= objectDTOBuilder.predictionDtoToEntity(predictionDto, patient);
            predictionRepository.save(prediction);

            response.put("message", "Patient added!");
            response.put("success", true);
            return response;

        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success",false);
            return response;
        }
    }

    public List<PredictionDto> findAll() {
        List<Prediction> predictionList = predictionRepository.findAll();

        List<PredictionDto> predictionDtos = new ArrayList<>();

        ObjectDtoBuilder objectDTOBuilder = new ObjectDtoBuilder();

        for (Prediction prediction : predictionList) {
            predictionDtos.add((PredictionDto) objectDTOBuilder.entityToDTO(prediction));
        }

        return predictionDtos;
    }

    public List<PredictionDto> findPredictionsByPatient(int patientId){
        Patient patient = patientRepository.findPatientByMyId(patientId);

        List<Prediction> predictionList = predictionRepository.findAllByPatient(patient);

        ObjectDtoBuilder objectDTOBuilder = new ObjectDtoBuilder();
        List<PredictionDto> predictionDtos = new ArrayList<>();
        if(predictionList.isEmpty()) {
            predictionDtos = null;
        } else {
            for (Prediction prediction : predictionList) {
                predictionDtos.add((PredictionDto) objectDTOBuilder.entityToDTO(prediction));
            }
        }
        return predictionDtos;
    }
}
