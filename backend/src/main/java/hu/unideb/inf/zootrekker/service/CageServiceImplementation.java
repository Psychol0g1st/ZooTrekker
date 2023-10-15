package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Cage;
import hu.unideb.inf.zootrekker.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CageServiceImplementation implements CageService{

    @Autowired
    private CageRepository cageRepository;

    @Override
    public Cage saveCage(Cage cage) {
        return cageRepository.save(cage);
    }

    @Override
    public List<Cage> getAllCage() {
        return (List<Cage>) cageRepository.findAll();
    }

    @Override
    public Cage updateCage(Cage cage, Long cageId) {
        Cage ujCage = cageRepository.findById(cageId).get();

        if (Objects.nonNull(cage.getName()) && !"".equalsIgnoreCase(cage.getName())) {
            .setName(cage.getName());
        }
        if (cage.getPositionX() != null) {
            try {
                ujCage.setPositionX(cage.getPositionX());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (cage.getPositionY() != null) {
            try {
                ujCage.setPositionY(cage.getPositionY());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        cageRepository.save();
        return ;
    }

    @Override
    public void deleteCageById(Long cageId) {
        cageRepository.deleteById(cageId);
    }
}
