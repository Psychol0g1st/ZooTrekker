package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.HealthRecord;
import hu.unideb.inf.zootrekker.repository.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthRecordServiceImplementation implements HealthRecordService{

    @Autowired
    HealthRecordRepository healthRecordRepository;

    @Override
    public HealthRecord saveHealthRecord(HealthRecord healthRecord) {
        return healthRecordRepository.save(healthRecord);
    }

    @Override
    public HealthRecord getHealthRecordById(Long id) {
        return healthRecordRepository.findById(id).isPresent() ? healthRecordRepository.findById(id).get() : null;
    }

    @Override
    public List<HealthRecord> getAllHealthRecords() {
        return healthRecordRepository.findAll();
    }

    @Override
    public HealthRecord updateHealthRecord(HealthRecord healthRecord, Long id) {
        Optional<HealthRecord> healthRecordToUpdate = healthRecordRepository.findById(id);
        if (healthRecordToUpdate.isPresent())
            healthRecord.setId(id);
        return healthRecordRepository.save(healthRecord);
    }

    @Override
    public void deleteHealthRecordById(Long id) {
        healthRecordRepository.deleteById(id);
    }
}
