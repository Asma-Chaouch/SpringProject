package com.SDE.demo.Services;

import com.SDE.demo.Enities.Entreprise;

import java.util.List;
import java.util.Optional;

public interface EntrepriseService {
    Entreprise ajouterEntreprise(Entreprise entreprise);
   /* String ajouterCV(String cv);*/
    Entreprise modifierEntreprise(Entreprise entreprise, Long id);
    List<Entreprise> listEntreprise();

    void supprimerById(Long id);
    Optional<Entreprise> getEntrepriseById(Long id);
}
