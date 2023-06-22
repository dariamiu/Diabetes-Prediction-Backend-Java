package diabtes_predication.controller;

import diabtes_predication.model.dto.PredictionDto;
import diabtes_predication.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/diabetes-prediction/predict")
@CrossOrigin(origins = "http://localhost:3000")
public class PredictController {
    @Autowired
    PredictionService predictionService;

    @PostMapping("/make-prediction")
    HashMap<String,Object> predict(@RequestBody PredictionDto predictionDto) {
        return predictionService.predict(predictionDto);
    }
}
