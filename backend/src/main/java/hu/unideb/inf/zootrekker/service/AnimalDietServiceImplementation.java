package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.AnimalDiet;
import hu.unideb.inf.zootrekker.repository.AnimalDietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnimalDietServiceImplementation implements AnimalDietService{

    @Autowired
    private AnimalDietRepository animalDietRepository;

    @Override
    public AnimalDiet saveAnimalDiet(AnimalDiet AnimalDiet) {
        return animalDietRepository.save(AnimalDiet);
    }

    @Override
    public AnimalDiet getAnimalDietById(Long animalDietId) {
        if (animalDietRepository.findById(animalDietId).isPresent()) {
            return animalDietRepository.findById(animalDietId).get();
        }
        return null;
    }

    @Override
    public List<AnimalDiet> getAllAnimalDiets() {
        return animalDietRepository.findAll();
    }

    @Override
    public AnimalDiet updateAnimalDiet(AnimalDiet animalDiet, Long AnimalDietId) {
        AnimalDiet ujAD = animalDietRepository.findById(AnimalDietId).get();

        if (Objects.nonNull(animalDiet.getWeekdays()) && !"".equalsIgnoreCase(animalDiet.getWeekdays())) {
            ujAD.setWeekdays(animalDiet.getWeekdays());
        }

        if (Objects.nonNull(animalDiet.getAmount())) {
            ujAD.setAmount(animalDiet.getAmount());
        }

        if (Objects.nonNull(animalDiet.getHours()) && !"".equalsIgnoreCase(animalDiet.getHours())) {
            ujAD.setHours(animalDiet.getHours());
        }

        if (Objects.nonNull(animalDiet.getSubstance())) {
            ujAD.setSubstance(animalDiet.getSubstance());
        }

        return animalDietRepository.save(ujAD);
    }

    @Override
    public void deleteAnimalDietById(Long AnimalDietId) {
        animalDietRepository.deleteById(AnimalDietId);
    }
}
