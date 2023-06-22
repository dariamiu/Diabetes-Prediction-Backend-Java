package diabtes_predication.model.dto;

import javax.persistence.Column;

public class PredictionDto {

    private String gender;

    private int age;

    private boolean hypertension;


    private boolean heart_disease;


    private String smoking_history;


    private float bmi;

    private float HbA1c_level;

    private float blood_glucose_level;

    private boolean diabetes;

    private int patient_unique_code;

    public PredictionDto(String gender, int age, boolean hypertension, boolean heart_disease, String smoking_history, float bmi, float HbA1c_level, float blood_glucose_level) {
        this.gender = gender;
        this.age = age;
        this.hypertension = hypertension;
        this.heart_disease = heart_disease;
        this.smoking_history = smoking_history;
        this.bmi = bmi;
        this.HbA1c_level = HbA1c_level;
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

    public int getPatient_unique_code() {
        return patient_unique_code;
    }

    public void setPatient_unique_code(int patient_unique_code) {
        this.patient_unique_code = patient_unique_code;
    }

    public float getHbA1c_level() {
        return HbA1c_level;
    }

    public void setHbA1c_level(float hbA1c_level) {
        HbA1c_level = hbA1c_level;
    }
}
