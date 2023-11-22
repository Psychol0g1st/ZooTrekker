package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Species;
import hu.unideb.inf.zootrekker.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SpeciesServiceImplementation implements SpeciesService{

    @Autowired
    private SpeciesRepository speciesRepository;

    @Override
    public Species saveSpecies(Species species) {
        return speciesRepository.save(species);
    }

    @Override
    public Species getSpeciesById(Long speciesId) {
        if (speciesRepository.findById(speciesId).isPresent()) {
            return  speciesRepository.findById(speciesId).get();
        }
        return null;
    }

    @Override
    public List<Species> getAllSpeciess() {
        return (List<Species>) speciesRepository.findAll();
    }

    @Override
    public Species updateSpecies(Species species, Long speciesId) {
        Species ujSpecies = speciesRepository.findById(speciesId).get();

        if (Objects.nonNull(species.getName()) && !"".equalsIgnoreCase(species.getName())) {
            ujSpecies.setName(species.getName());
        }
        speciesRepository.save(ujSpecies);
        return ujSpecies;
    }

    @Override
    public void deleteSpeciesById(Long speciesId) {
        speciesRepository.deleteById(speciesId);
    }
}
