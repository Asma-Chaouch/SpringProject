package com.SDE.demo.RestController;

import com.SDE.demo.Enities.Secteur_Activite;
import com.SDE.demo.Repository.Secteur_ActiviteRepository;
import com.SDE.demo.Services.Secteur_ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/secteurAcivite")
@CrossOrigin("*")
public class Secteur_ActiviteRestController {
    private Secteur_ActiviteRepository secteurActiviteRepository;

    @Autowired
    public Secteur_ActiviteRestController(Secteur_ActiviteRepository secteurActiviteRepository) {

        this.secteurActiviteRepository = secteurActiviteRepository;

    }
    @Autowired
    Secteur_ActiviteService secteurActiviteService;
    @RequestMapping(method = RequestMethod.POST)
    public Secteur_Activite ajoutSecteur_Activite(@RequestBody Secteur_Activite secteurActivite){

        Secteur_Activite savedUser = secteurActiviteRepository.save(secteurActivite);

        return secteurActiviteService.ajouterSecteurActivite(secteurActivite);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Secteur_Activite modifierSecteur_Activite(@PathVariable("id")Long id,@RequestBody Secteur_Activite secteurActivite){
        Secteur_Activite newSecteur_Activite=secteurActiviteService.modifierSecteur_Activite(secteurActivite);
        return newSecteur_Activite;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Secteur_Activite> listesecteurActivite(){
        return secteurActiviteService.listesecteurActivite();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        secteurActiviteService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Secteur_Activite> getSecteur_ActiviteById(@PathVariable("id") long id){
        Optional<Secteur_Activite> secteurActivite = secteurActiviteService.getSecteurActiviteById(id);
        return secteurActivite;
    }
}
