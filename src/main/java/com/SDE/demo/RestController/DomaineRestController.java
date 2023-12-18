package com.SDE.demo.RestController;

import com.SDE.demo.Enities.Domaine;
import com.SDE.demo.Repository.DomaineRepository;
import com.SDE.demo.Services.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

public class DomaineRestController {
    private DomaineRepository domaineRepository;

    public DomaineRestController(DomaineRestController domaineRestController){
        this.domaineRepository=domaineRepository;}
    @Autowired
    DomaineService domaineService;

    @RequestMapping(method = RequestMethod.POST)
    public Domaine ajouterDomaine(@RequestBody Domaine domaine){
        return domaineService.ajouterDomaine(domaine);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Domaine modifierDomaine(@RequestBody Domaine domaine){
        return domaineService.modifierDomaine(domaine);
    }
    @RequestMapping(method = RequestMethod.GET)
    List<Domaine> listeDomaine() {
        return domaineService.listeDomaine();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public  void supprimerById(@PathVariable("id") long id){
        domaineService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Domaine> getDomaineById(@PathVariable("id") long id){
        Optional<Domaine> domaine = domaineService.getDomaineById(id);
        return domaine;
    }
}
