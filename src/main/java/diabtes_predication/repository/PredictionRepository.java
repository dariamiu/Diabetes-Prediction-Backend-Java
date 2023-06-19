package diabtes_predication.repository;

import diabtes_predication.model.Patient;
import diabtes_predication.model.Prediction;
import diabtes_predication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Integer> {
    List<Prediction> findAllByPatient(Patient patient);
}
