package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.Climate;
import hu.unideb.inf.zootrekker.service.ClimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/climate")
public class ClimateController {
    @Autowired private ClimateService climateService;
    @PostMapping("/add")
    public Climate saveClimate(@RequestBody Climate climate)
    {
        return climateService.saveClimate(climate);
    }

    @GetMapping("/getall")
    public List<Climate> getAllClimate()
    {
        return climateService.getAllClimates();
    }

    @PutMapping("/update/{id}")
    public Climate updateClimate(@RequestBody Climate climate, @PathVariable("id") Long climateId)
    {
        return climateService.updateClimate(climate, climateId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClimateById(@PathVariable("id") Long climateId)
    {
        climateService.deleteClimateById(climateId);
        return "Deleted Successfully!";
    }
}