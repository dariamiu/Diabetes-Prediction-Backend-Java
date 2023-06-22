package diabtes_predication.controller;

import diabtes_predication.model.dto.PredictionDto;
import diabtes_predication.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diabetes-prediction/prediction-history")
@CrossOrigin(origins = "http://localhost:3000")
public class ViewHistoryPredictionController {
    @Autowired
    PredictionService predictionService;

    @GetMapping("/view-all")
    public List<PredictionDto> viewAll(){
        return predictionService.findAll();
    }


    @GetMapping("/view-by-patient/{id}")
    public List<PredictionDto> viewByPatient(@PathVariable int id){
        return predictionService.findPredictionsByPatient(id);
    }
}
