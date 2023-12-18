package com.SDE.demo.Services;

import com.SDE.demo.Enities.Offre;
import com.SDE.demo.Enities.Titre;

import java.util.List;
import java.util.Optional;

public interface TitreService {
    Titre ajouterTitre(Titre titre);
    Titre modifierTitre(Titre titre);
    void supprimerTitre(Titre titre);
    List<Titre> listetitre();
    void supprimerById(Long id);
    Optional<Titre> getTitreById(Long id);
}
