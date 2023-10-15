package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.Betyar;
import hu.unideb.inf.zootrekker.service.BetyarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BetyarController {
    @Autowired private BetyarService betyarService;
    @PostMapping("/add")
    public Betyar saveBetyar(@RequestBody Betyar betyar)
    {
        return betyarService.saveBetyar(betyar);
    }

    @GetMapping("/getall")
    public List<Betyar> getAllBetyars()
    {
        return betyarService.getAllBetyars();
    }

    @PutMapping("/update/{id}")
    public Betyar updateBetyar(@RequestBody Betyar betyar, @PathVariable("id") Long betyarId)
    {
        return betyarService.updateBetyar(betyar, betyarId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBetyarById(@PathVariable("id") Long betyarId)
    {
        betyarService.deleteBetyarById(betyarId);
        return "Deleted Successfully!";
    }
}
