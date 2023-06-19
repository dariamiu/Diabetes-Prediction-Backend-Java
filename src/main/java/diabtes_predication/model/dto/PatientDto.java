package diabtes_predication.model.dto;

import javax.persistence.Column;

public class PatientDto {

    private String name;

    private String gender;

    public PatientDto(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

}
