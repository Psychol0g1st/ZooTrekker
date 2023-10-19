package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Cage;
import hu.unideb.inf.zootrekker.entity.Climate;
import hu.unideb.inf.zootrekker.repository.CageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CageServiceImplementation implements CageService {

    @Autowired
    private CageRepository cageRepository;

    @Override
    public Cage saveCage(Cage cage) {
        return cageRepository.save(cage);
    }

    @Override
    public Cage getCageById(Long cageId) {
        if (cageRepository.findById(cageId).isPresent()) {
            return cageRepository.findById(cageId).get();
        }
        return null;
    }

    @Override
    public List<Cage> getAllCages() {
        return cageRepository.findAll();
    }

    @Override
    public Cage updateCage(Cage cage, Long cageId) {
        Cage updatedCage = cageRepository.findById(cageId).orElse(null);

        if (updatedCage != null) {
            if (Objects.nonNull(cage.getClimate())) {
                updatedCage.setClimate(cage.getClimate());
            }

            if (Objects.nonNull(cage.getName())) {
                updatedCage.setName(cage.getName());
            }

            if (Objects.nonNull(cage.getPositionX())) {
                updatedCage.setPositionX(cage.getPositionX());
            }

            if (Objects.nonNull(cage.getPositionY())) {
                updatedCage.setPositionY(cage.getPositionY());
            }

            // Save the updated cage to the repository
            return cageRepository.save(updatedCage);
        }
        return null;
    }

    @Override
    public void deleteCageById(Long cageId) {
        cageRepository.deleteById(cageId);
    }

    @Override
    public void addClimateToCage(Long cageId, Climate climate) {
        Cage cage = cageRepository.findById(cageId).orElse(null);
        if (cage != null) {
            cage.setClimate(climate);
            cageRepository.save(cage);
        }
    }

    @Override
    public Climate getClimateByCage(Long cageId) {
        Cage cage = cageRepository.findById(cageId).orElse(null);
        return (cage != null) ? cage.getClimate() : null;
    }
}
