package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Species;
import java.util.List;

public interface SpeciesService {
    // Save Species
    Species saveSpecies(Species species);

    // Read operation
    Species getSpeciesById(Long speciesId);
    List<Species> getAllSpeciess();

    // Update operation
    Species updateSpecies(Species species, Long SpeciesId);

    // Delete operation
    void deleteSpeciesById(Long SpeciesId);
}
