package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.AnimalDiet;

import java.util.List;

public interface AnimalDietService {
    // Save AnimalDiet
    AnimalDiet saveAnimalDiet(AnimalDiet AnimalDiet);

    AnimalDiet getAnimalDietById(Integer animalDietId);
    // Read operation
    List<AnimalDiet> getAllAnimalDiets();

    // Update operation
    AnimalDiet updateAnimalDiet(AnimalDiet AnimalDiet, Integer AnimalDietId);

    // Delete operation
    void deleteAnimalDietById(Integer AnimalDietId);
}
