package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Animal;
import hu.unideb.inf.zootrekker.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnimalServiceImplementation  implements AnimalService{

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal getAnimalById(Long id) {
        if (animalRepository.findById(id).isPresent())
            return animalRepository.findById(id).get();
        return null;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal updateAnimal(Animal animal, Long id) {
        Optional<Animal> animalToUpdate = animalRepository.findById(id);
        if (animalToUpdate.isPresent())
            animal.setId(id);
        System.out.println("Animal: " + animal);

        return animalRepository.save(animal);
    }

    @Override
    public void deleteAnimalById(Long id) {
        animalRepository.deleteById(id);
    }
}
