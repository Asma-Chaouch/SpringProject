package com.SDE.demo.RestController;

import com.SDE.demo.Enities.Adresse;
import com.SDE.demo.Enities.Lieu;
import com.SDE.demo.Repository.AdresseRepository;
import com.SDE.demo.Repository.LieuRepository;
import com.SDE.demo.Services.AdresseService;
import com.SDE.demo.Services.LieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/lieu")
@CrossOrigin("*")
public class LieuRestController {
    private LieuRepository lieuRepository;

    @Autowired
    public LieuRestController(LieuRepository lieuRepository) {

        this.lieuRepository = lieuRepository;

    }
    @Autowired
    LieuService lieuService;
    @RequestMapping(method = RequestMethod.POST)
    public Lieu ajoutLieu(@RequestBody Lieu lieu){

        Lieu savedUser = lieuRepository.save(lieu);

        return lieuService.ajouterLieu(lieu);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Lieu modifierLieu(@PathVariable("id")Long id,@RequestBody Lieu lieu){
        Lieu newLieu=lieuService.modifierLieu(lieu,id);
        return newLieu;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Lieu> listelieu(){
        return lieuService.listeLieu();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        lieuService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Lieu> getLieuById(@PathVariable("id") long id){
        Optional<Lieu> lieu = lieuService.getLieuById(id);
        return lieu;
    }
}
