package com.SDE.demo.Services;

import com.SDE.demo.Enities.Offre;
import com.SDE.demo.Enities.Type_Entreprise;

import java.util.List;
import java.util.Optional;

public interface Type_EntrepriseService {
    Type_Entreprise ajouterType_Entreprise(Type_Entreprise typeEntreprise);
    Type_Entreprise modifierType_Entreprise(Type_Entreprise typeEntreprise);
    void supprimerType_Entreprise(Type_Entreprise typeEntreprise);
    List<Type_Entreprise> listetypeEntreprise();
    void supprimerById(Long id);
    Optional<Type_Entreprise> getType_EntrepriseById(Long id);
}
