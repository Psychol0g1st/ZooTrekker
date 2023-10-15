package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Betyar;

import java.util.List;

public interface BetyarService {
    // Save betyar
    Betyar saveBetyar(Betyar Betyar);

    // Read operation
    List<Betyar> getAllBetyars();

    // Update operation
    Betyar updateBetyar(Betyar Betyar, Long BetyarId);

    // Delete operation
    void deleteBetyarById(Long BetyarId);
}
