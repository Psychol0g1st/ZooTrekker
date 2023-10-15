package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Betyar;
import hu.unideb.inf.zootrekker.repository.BetyarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BetyarServiceImplementation implements BetyarService{

    @Autowired
    private BetyarRepository betyarRepository;

    @Override
    public Betyar saveBetyar(Betyar betyar) {
        return betyarRepository.save(betyar);
    }

    @Override
    public List<Betyar> getAllBetyars() {
        return (List<Betyar>) betyarRepository.findAll();
    }

    @Override
    public Betyar updateBetyar(Betyar betyar, Long betyarId) {
        Betyar ujBetyar = betyarRepository.findById(betyarId).get();
        
        if (Objects.nonNull(betyar.getNev()) && !"".equalsIgnoreCase(betyar.getNev())) {
            ujBetyar.setNev(betyar.getNev());
        }

        if (betyar.getOrr() != null) {
            try {
                ujBetyar.setOrr(betyar.getOrr());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        if (betyar.getIsStrong() != null)
        {
            ujBetyar.setIsStrong(betyar.getIsStrong());
        }

        return betyarRepository.save(ujBetyar);
    }

    @Override
    public void deleteBetyarById(Long betyarId) {
        betyarRepository.deleteById(betyarId);
    }
}
