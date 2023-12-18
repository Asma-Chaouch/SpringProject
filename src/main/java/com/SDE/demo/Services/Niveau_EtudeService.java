package com.SDE.demo.Services;

import com.SDE.demo.Enities.Lieu;
import com.SDE.demo.Enities.Niveau_Etude;

import java.util.List;
import java.util.Optional;

public interface Niveau_EtudeService {
    Niveau_Etude ajouterNiveauEtude(Niveau_Etude niveauEtude);
    Niveau_Etude modifierNiveauEtude(Niveau_Etude niveauEtude,Long id);
    List<Niveau_Etude> listeNiveauEtude();

    void supprimerById(Long id);
    Optional<Niveau_Etude> getNiveauEtudeById(Long id);
}
