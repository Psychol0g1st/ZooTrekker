package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.Animal;
import hu.unideb.inf.zootrekker.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping("/add")
    public Animal saveAnimal(@RequestBody Animal animal) {
        return animalService.saveAnimal(animal);
    }

    @GetMapping("/get/{id}")
    public Animal getAnimalById(@PathVariable("id") Long id) {
        return animalService.getAnimalById(id);
    }

    @GetMapping("/getall")
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @PutMapping("/update/{id}")
    public Animal updateAnimal(@RequestBody Animal animal, @PathVariable("id") Long id) {
        return animalService.updateAnimal(animal, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable("id") Long id) {
        animalService.deleteAnimalById(id);
        return "Deleted successfully!";
    }
}
