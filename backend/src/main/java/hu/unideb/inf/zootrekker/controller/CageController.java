package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.Cage;
import hu.unideb.inf.zootrekker.entity.Climate;
import hu.unideb.inf.zootrekker.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cage")
public class CageController {
    @Autowired private CageService cageService;
    @PostMapping("/add")
    public Cage saveCage(@RequestBody Cage cage)
    {
        return cageService.saveCage(cage);
    }

    @GetMapping("/getall")
    public List<Cage> getAllCage()
    {
        return cageService.getAllCage();
    }

    @PutMapping("/update/{id}")
    public Cage updateCage(@RequestBody Cage cage, @PathVariable("id") Long cageId)
    {
        return cageService.updateCage(cage, cageId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCageById(@PathVariable("id") Long cageId)
    {
        cageService.deleteCageById(cageId);
        return "Deleted Successfully!";
    }
}
