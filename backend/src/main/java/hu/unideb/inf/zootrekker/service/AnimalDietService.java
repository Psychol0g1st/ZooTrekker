package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.AnimalDiet;

import java.util.List;

public interface AnimalDietService {
    // Save AnimalDiet
    AnimalDiet saveAnimalDiet(AnimalDiet AnimalDiet);

    AnimalDiet getAnimalDietById(Long animalDietId);
    // Read operation
    List<AnimalDiet> getAllAnimalDiets();

    // Update operation
    AnimalDiet updateAnimalDiet(AnimalDiet AnimalDiet, Long AnimalDietId);

    // Delete operation
    void deleteAnimalDietById(Long AnimalDietId);
}
