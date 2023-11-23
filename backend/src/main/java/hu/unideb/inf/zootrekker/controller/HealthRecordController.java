package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.HealthRecord;
import hu.unideb.inf.zootrekker.service.HealthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/healthrecord")
public class HealthRecordController {
    @Autowired
    private HealthRecordService healthRecordService;

    @PostMapping("/add")
    public HealthRecord saveHealthRecord(@RequestBody HealthRecord healthRecord) {
        return  healthRecordService.saveHealthRecord(healthRecord);
    }

    @GetMapping("/get/{id}")
    public HealthRecord getHealthRecordById(@PathVariable("id") Long id) {
        return healthRecordService.getHealthRecordById(id);
    }

    @GetMapping("/getall")
    public List<HealthRecord> getAllHealthRecords() {
        return healthRecordService.getAllHealthRecords();
    }

    @PutMapping("/update/{id}")
    public HealthRecord updateHealthRecord(@RequestBody HealthRecord healthRecord, @PathVariable("id") Long id) {
        return  healthRecordService.updateHealthRecord(healthRecord, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHealthRecord(@PathVariable("id") Long id) {
        healthRecordService.deleteHealthRecordById(id);
        return "Deleted successfully";
    }
}
