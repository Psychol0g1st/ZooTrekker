package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Substance;

import java.util.List;

public interface SubstanceService {
    // Save Substance
    Substance saveSubstance(Substance Substance);

    // Read operation
    List<Substance> getAllSubstances();

    // Update operation
    Substance updateSubstance(Substance Substance, Integer SubstanceId);

    // Delete operation
    void deleteSubstanceById(Integer SubstanceId);
}
