package diabtes_predication.model.dto;

import javax.persistence.Column;

public class PredictionDto {

    private String gender;

    private int age;

    private boolean hypertension;


    private boolean heart_disease;


    private String smoking_history;


    private float bmi;


    private float blood_glucose_level;

    private boolean diabetes;

    private int patientId;

    public PredictionDto(String gender, int age, boolean hypertension, boolean heart_disease, String smoking_history, float bmi, float blood_glucose_level) {
        this.gender = gender;
        this.age = age;
        this.hypertension = hypertension;
        this.heart_disease = heart_disease;
        this.smoking_history = smoking_history;
        this.bmi = bmi;
        this.blood_glucose_level = blood_glucose_level;
    }

    public int getAge() {
        return age;
    }

    public boolean isHypertension() {
        return hypertension;
    }

    public boolean isHeart_disease() {
        return heart_disease;
    }

    public String getSmoking_history() {
        return smoking_history;
    }

    public float getBmi() {
        return bmi;
    }

    public float getBlood_glucose_level() {
        return blood_glucose_level;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHypertension(boolean hypertension) {
        this.hypertension = hypertension;
    }

    public void setHeart_disease(boolean heart_disease) {
        this.heart_disease = heart_disease;
    }

    public void setSmoking_history(String smoking_history) {
        this.smoking_history = smoking_history;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public void setBlood_glucose_level(float blood_glucose_level) {
        this.blood_glucose_level = blood_glucose_level;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }
}
