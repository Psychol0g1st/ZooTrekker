package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Substance;
import hu.unideb.inf.zootrekker.repository.SubstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubstanceServiceImplementation implements SubstanceService{

    @Autowired
    private SubstanceRepository substanceRepository;

    @Override
    public Substance saveSubstance(Substance Substance) {
        return substanceRepository.save(Substance);
    }

    @Override
    public List<Substance> getAllSubstances() {
        return substanceRepository.findAll();
    }

    @Override
    public Substance updateSubstance(Substance substance, Integer substanceId) {
        Substance ujSubstance = substanceRepository.findById(substanceId).get();

        if (Objects.nonNull(substance.getName()) && !"".equalsIgnoreCase(substance.getName())) {
            ujSubstance.setName(substance.getName());
        }

        if (Objects.nonNull(substance.getUnit()) && !"".equalsIgnoreCase(substance.getUnit())) {
            ujSubstance.setUnit(substance.getUnit());
        }

        if (Objects.nonNull(substance.getStock())) {
            ujSubstance.setStock(substance.getStock());
        }

        if (Objects.nonNull(substance.getType())) {
            ujSubstance.setType(substance.getType());
        }

        return substanceRepository.save(ujSubstance);
    }

    @Override
    public void deleteSubstanceById(Integer SubstanceId) {
        substanceRepository.deleteById(SubstanceId);
    }
}
