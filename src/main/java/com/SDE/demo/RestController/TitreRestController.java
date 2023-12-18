package com.SDE.demo.RestController;

import com.SDE.demo.Enities.Titre;
import com.SDE.demo.Repository.TitreRepository;
import com.SDE.demo.Services.TitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/titre")
@CrossOrigin("*")
public class TitreRestController {
    private TitreRepository titreRepository;

    @Autowired
    public TitreRestController(TitreRepository titreRepository) {

        this.titreRepository = titreRepository;

    }
    @Autowired
    TitreService titreService;
    @RequestMapping(method = RequestMethod.POST)
    public Titre ajoutTitre(@RequestBody Titre titre){

        Titre savedUser = titreRepository.save(titre);

        return titreService.ajouterTitre(titre);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Titre modifierTitre(@PathVariable("id")Long id,@RequestBody Titre titre){
        Titre newTitre=titreService.modifierTitre(titre);
        return newTitre;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Titre> listetitre(){
        return titreService.listetitre();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        titreService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Titre> getTitreById(@PathVariable("id") long id){
        Optional<Titre> titre = titreService.getTitreById(id);
        return titre;
    }
}
