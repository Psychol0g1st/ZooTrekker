package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Cage;
import java.util.List;

public interface CageService {
    // Save Species
    Cage saveCage(Cage cage);

    // Read operation
    List<Cage> getAllCage();

    // Update operation
    Cage updateCage(Cage cage, Long CageId);

    // Delete operation
    void deleteCageById(Long CageId);
}
