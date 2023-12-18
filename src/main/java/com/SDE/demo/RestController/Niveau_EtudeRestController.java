package com.SDE.demo.RestController;

import com.SDE.demo.Enities.Niveau_Etude;
import com.SDE.demo.Repository.Niveau_EtudeRepository;
import com.SDE.demo.Services.Niveau_EtudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/niveauEtude")
@CrossOrigin("*")
public class Niveau_EtudeRestController {
    private Niveau_EtudeRepository niveauEtudeRepository;

    @Autowired
    public Niveau_EtudeRestController(Niveau_EtudeRepository niveauEtudeRepository) {

        this.niveauEtudeRepository = niveauEtudeRepository;

    }
    @Autowired
    Niveau_EtudeService niveauEtudeService;
    @RequestMapping(method = RequestMethod.POST)
    public Niveau_Etude ajoutNiveau_Etude(@RequestBody Niveau_Etude niveauEtude){

        Niveau_Etude savedUser = niveauEtudeRepository.save(niveauEtude);

        return niveauEtudeService.ajouterNiveauEtude(niveauEtude);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Niveau_Etude modifierNiveau_Etude(@PathVariable("id")Long id,@RequestBody Niveau_Etude niveauEtude){
        Niveau_Etude newNiveau_Etude=niveauEtudeService.modifierNiveauEtude(niveauEtude,id);
        return newNiveau_Etude;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Niveau_Etude> listeniveauEtude(){
        return niveauEtudeService.listeNiveauEtude();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        niveauEtudeService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Niveau_Etude> getNiveau_EtudeById(@PathVariable("id") long id){
        Optional<Niveau_Etude> niveauEtude = niveauEtudeService.getNiveauEtudeById(id);
        return niveauEtude;
    }

}
