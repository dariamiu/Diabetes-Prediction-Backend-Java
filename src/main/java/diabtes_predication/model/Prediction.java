package diabtes_predication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Prediction {

    @Id
    @GeneratedValue
    private Integer prediction_id;

    @Column
    private int age;

    @Column
    private boolean hypertension;

    @Column
    private boolean heart_disease;

    @Column
    private String smoking_history;

    @Column
    private float bmi;

    @Column
    private float HbA1c_level;


    @Column
    private float blood_glucose_level;

    @Column
    private boolean diabetes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Prediction(int age, boolean hypertension, boolean heart_disease, String smoking_history, float bmi, float blood_glucose_level, Patient patient) {
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

    public Patient getPatient() {
        return patient;
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

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public float getHbA1c_level() {
        return HbA1c_level;
    }

    public void setHbA1c_level(float hbA1c_level) {
        HbA1c_level = hbA1c_level;
    }
}
