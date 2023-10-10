package com.example.demo.service;

import com.example.demo.entity.Betyar;
import com.example.demo.repository.BetyarRepository;
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

        try {
            ujBetyar.setOrr(betyar.getOrr());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ujBetyar.setStrong(betyar.isStrong());

        return betyarRepository.save(ujBetyar);
    }

    @Override
    public void deleteBetyarById(Long betyarId) {
        betyarRepository.deleteById(betyarId);
    }
}
