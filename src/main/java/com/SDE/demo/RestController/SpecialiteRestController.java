package com.SDE.demo.RestController;

import com.SDE.demo.Enities.Specialite;
import com.SDE.demo.Repository.SpecialiteRepository;
import com.SDE.demo.Services.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/specialite")
@CrossOrigin("*")
public class SpecialiteRestController {
    private SpecialiteRepository specialiteRepository;

    @Autowired
    public SpecialiteRestController(SpecialiteRepository specialiteRepository) {

        this.specialiteRepository = specialiteRepository;

    }
    @Autowired
    SpecialiteService specialiteService;
    @RequestMapping(method = RequestMethod.POST)
    public Specialite ajoutSpecialite(@RequestBody Specialite specialite){

        Specialite savedUser = specialiteRepository.save(specialite);

        return specialiteService.ajouterSpecialite(specialite);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Specialite modifierSpecialite(@PathVariable("id")Long id,@RequestBody Specialite specialite){
        Specialite newSpecialite=specialiteService.modifierSpecialite(specialite);
        return newSpecialite;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Specialite> listespecialite(){
        return specialiteService.listespecialite();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        specialiteService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Specialite> getSpecialiteById(@PathVariable("id") long id){
        Optional<Specialite> specialite = specialiteService.getSpecialiteById(id);
        return specialite;
    }
}
