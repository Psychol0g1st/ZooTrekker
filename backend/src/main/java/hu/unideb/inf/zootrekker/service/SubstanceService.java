package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Substance;

import java.util.List;

public interface SubstanceService {
    // Save Substance
    Substance saveSubstance(Substance Substance);

    Substance getSubstanceById(Long SubstanceId);

    // Read operation
    List<Substance> getAllSubstances();

    // Update operation
    Substance updateSubstance(Substance Substance, Long SubstanceId);

    // Delete operation
    void deleteSubstanceById(Long SubstanceId);
}
