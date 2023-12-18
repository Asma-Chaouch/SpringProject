package com.SDE.demo.RestController;


import com.SDE.demo.Enities.*;
import com.SDE.demo.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/offre")
@CrossOrigin("*")
public class OffreRestController {
    @Autowired
    OffreService offreService;
   /* @Autowired
    CategoryService categoryService;*/
    @Autowired
    DomaineService domaineService;
    @Autowired
    Type_EmpService typeEmpService;
    @Autowired
    Niveau_EtudeService niveauEtudeService;
    @Autowired
    TitreService titreService;
    @Autowired
    LieuService lieuService;

    @RequestMapping(method = RequestMethod.POST)
    public Offre ajoutOffre(@RequestBody Offre offre){
        /*Categorie categorie = categoryService.ajouterCategorie(offre.getCategorie());*/
        Domaine domaine= domaineService.ajouterDomaine(offre.getDomaine());
        Type_Emp typeEmp=  typeEmpService.ajouterType_Emp(offre.getTypeEmp());
        Niveau_Etude niveauEtude= niveauEtudeService.ajouterNiveauEtude(offre.getNiveauEtude());
        Titre titre= titreService.ajouterTitre(offre.getTitre());
        Lieu lieu= lieuService.ajouterLieu(offre.getLieu());
        return offreService.ajouterOffre(offre);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Offre modifierOffre(@PathVariable("id")Long id,@RequestBody Offre offre){
       /* Categorie existingCategorie = categoryService.modifierCategorie(offre.getCategorie());*/
        Domaine existingDomaine = domaineService.modifierDomaine(offre.getDomaine());
        Type_Emp existingtypeemp = typeEmpService.modifierType_Emp(offre.getTypeEmp());
        Niveau_Etude exisitngniveu = niveauEtudeService.modifierNiveauEtude(offre.getNiveauEtude(),offre.getNiveauEtude().getId());
        Titre existingtitre = titreService.modifierTitre(offre.getTitre());
        Lieu exisitnglieu = lieuService.modifierLieu(offre.getLieu(),offre.getNiveauEtude().getId());
        Offre existingOffre= offreService.modifierOffre(offre,id);
            return existingOffre;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Offre> listeoffre(){
        return offreService.listeoffre();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        offreService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Offre> getOffreWithDetails(@PathVariable("id") Long id) {
        Optional<Offre> offreOptional = offreService.getOffreById(id);

        Offre offre = offreOptional.get();
       /* Optional<Categorie> categorieOptional = categoryService.getCategoryById(offre.getCategorie().getId());*/
        Optional<Domaine> domaineOptional= domaineService.getDomaineById(offre.getDomaine().getId());
        Optional<Type_Emp> typeEmpOptional= typeEmpService.getType_EmpById(offre.getTypeEmp().getId());
        Optional<Niveau_Etude> niveauEtudeOptional= niveauEtudeService.getNiveauEtudeById(offre.getNiveauEtude().getId());
        Optional<Titre> titreOptional = titreService.getTitreById(offre.getTitre().getId());
        Optional<Lieu> lieuOptional= lieuService.getLieuById(offre.getLieu().getId());
       /* offre.setCategorie(categorieOptional.orElse(null));*/
        offre.setDomaine(domaineOptional.orElse(null));
        offre.setTypeEmp(typeEmpOptional.orElse(null));
        offre.setNiveauEtude(niveauEtudeOptional.orElse(null));
        offre.setTitre(titreOptional.orElse(null));
        offre.setLieu(lieuOptional.orElse(null));
        return ResponseEntity.ok(offre);
    }

}

