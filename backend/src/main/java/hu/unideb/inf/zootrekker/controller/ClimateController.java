package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.Climate;
import hu.unideb.inf.zootrekker.service.ClimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/climates")
@RestController
@CrossOrigin
public class ClimateController {
    @Autowired
    private ClimateService climateService;

    @PostMapping("/add")
    public Climate saveClimate(@RequestBody Climate climate) {
        return climateService.saveClimate(climate);
    }

    @GetMapping("/get/{id}")
    public Climate getClimateById(@PathVariable("id") Long climateId) {
        return climateService.getClimateById(climateId);
    }

    @GetMapping("/getall")
    public List<Climate> getAllClimates() {
        return climateService.getAllClimates();
    }

    @PutMapping("/update/{id}")
    public Climate updateClimate(@RequestBody Climate climate, @PathVariable("id") Long climateId) {
        return climateService.updateClimate(climate, climateId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClimate(@PathVariable("id") Long climateId) {
        climateService.deleteClimateById(climateId);
        return "Deleted successfully!";
    }
}
