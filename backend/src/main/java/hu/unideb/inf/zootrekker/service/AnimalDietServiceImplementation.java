package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.AnimalDiet;
import hu.unideb.inf.zootrekker.repository.AnimalDietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalDietServiceImplementation implements AnimalDietService{

    @Autowired
    private AnimalDietRepository animalDietRepository;

    @Override
    public AnimalDiet saveAnimalDiet(AnimalDiet AnimalDiet) {
        return animalDietRepository.save(AnimalDiet);
    }

    @Override
    public List<AnimalDiet> getAllAnimalDiets() {
        return animalDietRepository.findAll();
    }

    @Override
    public AnimalDiet updateAnimalDiet(AnimalDiet AnimalDiet, Integer AnimalDietId) {
        //TODO
        return new AnimalDiet();
    }

    @Override
    public void deleteAnimalDietById(Integer AnimalDietId) {
        animalDietRepository.deleteById(AnimalDietId);
    }
}
