package com.SDE.demo.RestController;

import com.SDE.demo.Enities.Type_Entreprise;
import com.SDE.demo.Repository.Type_EntrepriseRepository;
import com.SDE.demo.Services.Type_EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/typeEntreprise")
@CrossOrigin("*")
public class Type_EntrepriseRestController {
    private Type_EntrepriseRepository typeEntrepriseRepository;

    @Autowired
    public Type_EntrepriseRestController(Type_EntrepriseRepository typeEntrepriseRepository) {

        this.typeEntrepriseRepository = typeEntrepriseRepository;

    }
    @Autowired
    Type_EntrepriseService typeEntrepriseService;
    @RequestMapping(method = RequestMethod.POST)
    public Type_Entreprise ajoutType_Entreprise(@RequestBody Type_Entreprise typeEntreprise){

        Type_Entreprise savedUser = typeEntrepriseRepository.save(typeEntreprise);

        return typeEntrepriseService.ajouterType_Entreprise(typeEntreprise);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Type_Entreprise modifierType_Entreprise(@PathVariable("id")Long id,@RequestBody Type_Entreprise typeEntreprise){
        Type_Entreprise newType_Entreprise=typeEntrepriseService.modifierType_Entreprise(typeEntreprise);
        return newType_Entreprise;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Type_Entreprise> listetypeEntreprise(){
        return typeEntrepriseService.listetypeEntreprise();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        typeEntrepriseService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Type_Entreprise> getType_EntrepriseById(@PathVariable("id") long id){
        Optional<Type_Entreprise> typeEntreprise = typeEntrepriseService.getType_EntrepriseById(id);
        return typeEntreprise;
    }
}
