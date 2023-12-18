package com.SDE.demo.RestController;


import com.SDE.demo.Enities.*;

import com.SDE.demo.Repository.CandidatRepository;
import com.SDE.demo.Repository.CandidatureRepository;

import com.SDE.demo.Repository.OffreRepository;
import com.SDE.demo.Services.CandidatService;
import com.SDE.demo.Services.CandidatureService;

import com.SDE.demo.Services.EmailService;
import com.SDE.demo.Services.OffreService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/candidatures")
@CrossOrigin("*")
public class CandidatureRestController {
    private CandidatureRepository candidatureRepository;
    private CandidatRepository candidatRepository;
    private OffreRepository offreRepository;

    public CandidatureRestController(CandidatureRepository candidatureRepository) {
        this.candidatureRepository = candidatureRepository;
    }

    @Autowired
    CandidatureService candidatureService;
    @Autowired
    OffreService offreService;
    @Autowired
    CandidatService candidatService;

    @RequestMapping(method = RequestMethod.POST)
    public Candidature ajouterCandidature(@RequestBody Candidature candidature) {
        Candidature savedUser = candidatureRepository.save(candidature);

        return candidatureService.ajouterCandidature(candidature);
    }

/*    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Candidature modifierCandidature(@PathVariable("id") Long id, @RequestBody Candidature candidature) {
        if (candidatureRepository.findById(id).isPresent()) {
            Candidature existingCandidature = candidatureRepository.findById(id).get();

            existingCandidature.setCv(candidature.getCv());
            existingCandidature.setEtatCandidature(candidature.isEtatCandidature());
            existingCandidature.setEtatDownload(candidature.isEtatDownload());

            // Check if the candidature request contains an Offre ID and Titre

                Optional <Offre> existingOffre = offreRepository.findById(candidature.getOffreId());

                Titre titre = new Titre();
                titre.setTitreE(candidature.getOffretitre());
                existingOffre.get().setTitre(titre);

                existingCandidature.setOffre(existingOffre.get());


            // Check if the candidature request contains a Candidat ID and Nom

                Optional <Candidat> existingCandidat = candidatRepository.findById(candidature.getCANId());


                existingCandidat.get().setNom(candidature.getNom());

                existingCandidature.setCandidat(existingCandidat.get());


            Candidature modifiedCandidature = candidatureService.modifierCandidature(existingCandidature, id);
            return modifiedCandidature;
        }

        return null;
    }
*/


    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Candidature modifierCandidat(@PathVariable("id")Long id,@RequestBody Candidature candidature){
        return candidatureService.modifierCandidature(candidature,id);
    }
    @RequestMapping(method = RequestMethod.GET)
    List<Candidature> listeCandidature() {
        return candidatureService.listeCandidature();
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public  void supprimerById(@PathVariable("id") long id){
        candidatureService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Candidature> getCandidatureById(@PathVariable("id") long id){
        Optional<Candidature> candidature = candidatureService.getCandidatureById(id);
        return candidature;
    }

    @PostMapping("/{candidatId}/{offreId}")
    public Candidature postuler(@PathVariable("candidatId") Long candidatId,
                                           @PathVariable("offreId") Long offreId,
                                           @RequestBody Map<String, String> requestBody) {
        String cvPath = requestBody.get("cv");
        return  candidatureService.postuler(candidatId, offreId, cvPath);

        }
    }

