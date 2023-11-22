package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Cage;
import hu.unideb.inf.zootrekker.entity.Climate;

import java.util.List;

public interface CageService {
    // Save Cage
    Cage saveCage(Cage cage);

    Cage getCageById(Long cageId);

    // Read operation
    List<Cage> getAllCages();

    // Update operation
    Cage updateCage(Cage cage, Long cageId);

    // Delete operation
    void deleteCageById(Long cageId);

    // Custom methods for managing the relationship

}
