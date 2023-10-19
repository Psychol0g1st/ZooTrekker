package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.Cage;
import hu.unideb.inf.zootrekker.service.CageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cage")
@RestController
public class CageController {
    @Autowired
    private CageService cageService;

    @PostMapping("/add")
    public Cage saveCage(@RequestBody Cage cage) {
        return cageService.saveCage(cage);
    }

    @GetMapping("/get/{id}")
    public Cage getCageById(@PathVariable("id") Long cageId) {
        return cageService.getCageById(cageId);
    }

    @GetMapping("/getall")
    public List<Cage> getAllCages() {
        return cageService.getAllCages();
    }

    @PutMapping("/update/{id}")
    public Cage updateCage(@RequestBody Cage cage, @PathVariable("id") Long cageId) {
        return cageService.updateCage(cage, cageId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCage(@PathVariable("id") Long cageId) {
        cageService.deleteCageById(cageId);
        return "Deleted successfully!";
    }
}
