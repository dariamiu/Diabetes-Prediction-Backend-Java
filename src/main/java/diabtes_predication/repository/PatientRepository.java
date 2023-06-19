package diabtes_predication.repository;
import diabtes_predication.model.Patient;
import diabtes_predication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
    @Query("SELECT p FROM Patient p WHERE p.id = ?1")
    Patient findPatientByMyId(Integer myId);

}
