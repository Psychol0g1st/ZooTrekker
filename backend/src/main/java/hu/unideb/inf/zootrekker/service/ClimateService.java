package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Climate;

import java.util.List;

public interface ClimateService {
    // Save Climate
    Climate saveClimate(Climate climate);

    Climate getClimateById(Long climateId);

    // Read operation
    List<Climate> getAllClimates();

    // Update operation
    Climate updateClimate(Climate climate, Long climateId);

    // Delete operation
    void deleteClimateById(Long climateId);
}
