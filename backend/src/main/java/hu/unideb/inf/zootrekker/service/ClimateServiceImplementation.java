package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Climate;
import hu.unideb.inf.zootrekker.entity.Climate;
import hu.unideb.inf.zootrekker.entity.Climate;
import hu.unideb.inf.zootrekker.repository.ClimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClimateServiceImplementation implements ClimateService{

    @Autowired
    private ClimateRepository climateRepositoryRepository;

    @Override
    public Climate saveClimate(Climate climate) {
        return climateRepositoryRepository.save(climate);
    }

    @Override
    public List<Climate> getAllClimates() {
        return (List<Climate>) climateRepositoryRepository.findAll();
    }

    @Override
    public Climate updateClimate(Climate climate, Long climateId) {
        Climate ujClimate = climateRepositoryRepository.findById(climateId).get();

        if (Objects.nonNull(climate.getName()) && !"".equalsIgnoreCase(climate.getName())) {
            ujClimate.setName(climate.getName());
        }
        if (climate.getTemperature() != null) {
            try {
                ujClimate.setTemperature(climate.getTemperature());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (climate.getHumidity() != null) {
            try {
                ujClimate.setHumidity(climate.getHumidity());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return climateRepositoryRepository.save(ujClimate);
    }

    @Override
    public void deleteClimateById(Long climateId) {
        climateRepositoryRepository.deleteById(climateId);
    }
}