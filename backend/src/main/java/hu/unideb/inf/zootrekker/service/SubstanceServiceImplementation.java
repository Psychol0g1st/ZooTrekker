package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Substance;
import hu.unideb.inf.zootrekker.repository.SubstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Substance updateSubstance(Substance Substance, Integer SubstanceId) {
        //TODO
        return new Substance();
    }

    @Override
    public void deleteSubstanceById(Integer SubstanceId) {
        substanceRepository.deleteById(SubstanceId);
    }
}
