package diabtes_predication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Patient {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String patient_unique_code;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prediction> predictions;

    public Patient(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    public String getPatient_unique_code() {
        return patient_unique_code;
    }

    public void setPatient_unique_code(String patient_unique_code) {
        this.patient_unique_code = patient_unique_code;
    }
}
