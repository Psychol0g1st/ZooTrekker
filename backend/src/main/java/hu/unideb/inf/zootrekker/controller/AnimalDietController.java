package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.AnimalDiet;
import hu.unideb.inf.zootrekker.service.AnimalDietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/animaldiet")
@RestController
public class AnimalDietController {
    @Autowired
    private AnimalDietService animalDietService;

    @PostMapping("/add")
    public AnimalDiet saveAnimalDiet(@RequestBody AnimalDiet animalDiet) {
        return animalDietService.saveAnimalDiet(animalDiet);
    }

    @GetMapping("/get/{id}")
    public AnimalDiet getAnimalDietById(@PathVariable("id") Long animalDietId) {
        return animalDietService.getAnimalDietById(animalDietId);
    }

    @GetMapping("/getall")
    public List<AnimalDiet> getAllAnimalDiets() {
        return animalDietService.getAllAnimalDiets();
    }

    @PutMapping("/update/{id}")
    public AnimalDiet updateAnimalDiet(@RequestBody AnimalDiet animalDiet, @PathVariable("id") Long animalDietId) {
        return animalDietService.updateAnimalDiet(animalDiet, animalDietId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAnimalDiet(@PathVariable("id") Long animalDietId) {
        animalDietService.deleteAnimalDietById(animalDietId);
        return "Deleted successfully!";
    }
}
