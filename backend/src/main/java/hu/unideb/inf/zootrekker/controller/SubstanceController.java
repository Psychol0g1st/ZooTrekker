package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.Substance;
import hu.unideb.inf.zootrekker.service.SubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/substance")
@RestController
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

    @PutMapping("/update/{id}")
    public Substance updateSubstance(@RequestBody Substance substance, @PathVariable("id") Integer substanceId) {
        return substanceService.updateSubstance(substance, substanceId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSubstance(@PathVariable("id") Integer substanceId) {
        substanceService.deleteSubstanceById(substanceId);
        return "Deleted successfully!";
    }
}

