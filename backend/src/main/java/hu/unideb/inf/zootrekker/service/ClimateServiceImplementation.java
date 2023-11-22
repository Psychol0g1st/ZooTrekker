package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Climate;
import hu.unideb.inf.zootrekker.repository.ClimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClimateServiceImplementation implements ClimateService {

    @Autowired
    private ClimateRepository climateRepository;

    @Override
    public Climate saveClimate(Climate climate) {
        return climateRepository.save(climate);
    }

    @Override
    public Climate getClimateById(Long climateId) {
        if (climateRepository.findById(climateId).isPresent()) {
            return climateRepository.findById(climateId).get();
        }
        return null;
    }

    @Override
    public List<Climate> getAllClimates() {
        return climateRepository.findAll();
    }

    @Override
    public Climate updateClimate(Climate climate, Long climateId) {
        Climate updatedClimate = climateRepository.findById(climateId).orElse(null);

        if (updatedClimate != null) {
            if (Objects.nonNull(climate.getHumidity())) {
                updatedClimate.setHumidity(climate.getHumidity());
            }

            if (Objects.nonNull(climate.getTemperature())) {
                updatedClimate.setTemperature(climate.getTemperature());
            }

            if (Objects.nonNull(climate.getName())) {
                updatedClimate.setName(climate.getName());
            }

            // Save the updated climate to the repository
            return climateRepository.save(updatedClimate);
        }
        return null;
    }

    @Override
    public void deleteClimateById(Long climateId) {
        climateRepository.deleteById(climateId);
    }
}
