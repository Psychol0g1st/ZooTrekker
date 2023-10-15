package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Climate;

import java.util.List;

public interface ClimateService {
    // Save auth
    Climate saveClimate(Climate Climate);

    // Read operation
    List<Climate> getAllClimates();

    // Update operation
    Climate updateClimate(Climate Climate, Long ClimateId);

    // Delete operation
    void deleteClimateById(Long ClimateId);
}