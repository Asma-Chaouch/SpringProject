package com.SDE.demo.Services;

import com.SDE.demo.Enities.Candidat;

import java.util.List;
import java.util.Optional;

public interface CandidatService {
    Candidat ajouterCandidat(Candidat candidat);
    Candidat modifierCandidat(Candidat candidat, Long id);
    /*Candidature postuler(Long candidatId, Long offreId, String cv);*/
    void supprimerCandidat(Candidat candidat);
    List<Candidat> listeCandidat();
    void supprimerById(Long id);
    Optional<Candidat> getCandidatById(Long id);



}
