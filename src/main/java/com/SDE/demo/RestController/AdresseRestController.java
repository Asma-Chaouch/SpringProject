package com.SDE.demo.RestController;

import com.SDE.demo.Enities.Admin;
import com.SDE.demo.Enities.Adresse;
import com.SDE.demo.Repository.AdminRepository;
import com.SDE.demo.Repository.AdresseRepository;
import com.SDE.demo.Services.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/adresse")
@CrossOrigin("*")
public class AdresseRestController {
    private AdresseRepository adresseRepository;

    @Autowired
    public AdresseRestController(AdresseRepository adresseRepository) {

        this.adresseRepository = adresseRepository;

    }
    @Autowired
    AdresseService adresseService;
    @RequestMapping(method = RequestMethod.POST)
    public Adresse ajoutAdresse(@RequestBody Adresse adresse){

        Adresse savedUser = adresseRepository.save(adresse);

        return adresseService.ajouterAdresse(adresse);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Adresse modifierAdresse(@PathVariable("id")Long id,@RequestBody Adresse adresse){
        Adresse newAdresse=adresseService.modifierAdresse(adresse);
        return newAdresse;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Adresse> listeadresse(){
        return adresseService.listeadresse();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        adresseService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Adresse> getAdresseById(@PathVariable("id") long id){
        Optional<Adresse> adresse = adresseService.getAdresseById(id);
        return adresse;
    }
}