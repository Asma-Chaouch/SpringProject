package com.SDE.demo.Services;

import com.SDE.demo.Enities.Offre;
import com.SDE.demo.Enities.Specialite;

import java.util.List;
import java.util.Optional;

public interface SpecialiteService {
    Specialite ajouterSpecialite(Specialite specialite);
    Specialite modifierSpecialite(Specialite specialite);
    void supprimerSpecialite(Specialite specialite);
    List<Specialite> listespecialite();
    void supprimerById(Long id);
    Optional<Specialite> getSpecialiteById(Long id);
}
