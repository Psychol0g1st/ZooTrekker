package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.Substance;
import hu.unideb.inf.zootrekker.service.SubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/substances")
@RestController
@CrossOrigin
public class SubstanceController {
    @Autowired
    private SubstanceService substanceService;

    @PostMapping("/add")
    public Substance saveSubstance(@RequestBody Substance substance) {
        return substanceService.saveSubstance(substance);
    }

    @GetMapping("/getall")
    public List<Substance> getAllSubstances() {
        return substanceService.getAllSubstances();
    }

    @GetMapping("/get/{id}")
    public Substance getSubstanceById(@PathVariable("id") Long substanceId) {
        return substanceService.getSubstanceById(substanceId);
    }

    @PutMapping("/update/{id}")
    public Substance updateSubstance(@RequestBody Substance substance, @PathVariable("id") Long substanceId) {
        return substanceService.updateSubstance(substance, substanceId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSubstance(@PathVariable("id") Long substanceId) {
        substanceService.deleteSubstanceById(substanceId);
        return "Deleted successfully!";
    }
}

