package diabtes_predication.model.dto;

import diabtes_predication.model.Patient;
import diabtes_predication.model.Prediction;

public class ObjectDtoBuilder {

    public Object entityToDTO (Object object){
        if (object instanceof Patient){
            return new PatientDto(((Patient) object).getName(), ((Patient) object).getGender());
        }
        else if (object instanceof Prediction) {
            return new PredictionDto(((Prediction) object).getPatient().getGender(),
                    ((Prediction) object).getAge(),
                    ((Prediction) object).isHypertension(),
                    ((Prediction) object).isHypertension(),
                    ((Prediction) object).getSmoking_history(),
                    ((Prediction) object).getBmi(),
                    ((Prediction) object).getHbA1c_level(),
                    ((Prediction) object).getBlood_glucose_level());
        }
        return null;
    }

    public Prediction predictionDtoToEntity(PredictionDto predictionDto, Patient patient){
        return new Prediction(predictionDto.getAge(),predictionDto.isHypertension(),predictionDto.isHeart_disease(),
                predictionDto.getSmoking_history(), predictionDto.getBmi(), predictionDto.getBlood_glucose_level(),patient);
    }

    public Patient patientDtoToEntity(PatientDto patientDto){
        return new Patient(patientDto.getName(),patientDto.getGender());
    }
}
