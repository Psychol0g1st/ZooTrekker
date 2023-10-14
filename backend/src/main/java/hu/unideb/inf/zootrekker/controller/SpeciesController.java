package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.Species;
import hu.unideb.inf.zootrekker.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/species")
public class SpeciesController {
    @Autowired private SpeciesService speciesService;
    @PostMapping("/add")
    public Species saveSpecies(@RequestBody Species species)
    {
        return speciesService.saveSpecies(species);
    }

    @GetMapping("/getall")
    public List<Species> getAllSpeciess()
    {
        return speciesService.getAllSpeciess();
    }

    @PutMapping("/update/{id}")
    public Species updateSpecies(@RequestBody Species species, @PathVariable("id") Long speciesId)
    {
        return speciesService.updateSpecies(species, speciesId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSpeciesById(@PathVariable("id") Long speciesId)
    {
        speciesService.deleteSpeciesById(speciesId);
        return "Deleted Successfully!";
    }
}
