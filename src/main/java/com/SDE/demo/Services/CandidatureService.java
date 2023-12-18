package com.SDE.demo.Services;

import com.SDE.demo.Enities.Admin;
import com.SDE.demo.Enities.Candidat;
import com.SDE.demo.Enities.Candidature;
import com.SDE.demo.Enities.Offre;

import java.util.List;
import java.util.Optional;

public interface CandidatureService {
    Candidature ajouterCandidature(Candidature candidature);
    //Candidature postuler(Candidat candidat , Offre offre);
   Candidature postuler(Long candidatId, Long offreId, String cvPath);
    Candidature modifierCandidature(Candidature candidature, Long id);
    void supprimerCandidature(Candidature candidature);
    List<Candidature> listeCandidature();
    void supprimerById(Long id);
    Optional<Candidature> getCandidatureById(Long id);

}
