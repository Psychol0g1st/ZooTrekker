package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.HealthRecord;

import java.util.List;

public interface HealthRecordService {
    // Save HealthRecord
    HealthRecord saveHealthRecord(HealthRecord healthRecord);

    HealthRecord getHealthRecordById(Long id);

    // Read operation
    List<HealthRecord> getAllHealthRecords();

    // Update operation
    HealthRecord updateHealthRecord(HealthRecord healthRecord, Long id);

    // Delete operation
    void deleteHealthRecordById(Long id);
}
