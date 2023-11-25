package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Animal;

import java.util.List;

public interface AnimalService {
    Animal saveAnimal(Animal animal);

    Animal getAnimalById(Long id);

    List<Animal> getAllAnimals();

    Animal updateAnimal(Animal animal, Long id);

    void deleteAnimalById(Long id);

}
