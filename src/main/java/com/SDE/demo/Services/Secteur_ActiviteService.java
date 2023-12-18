package com.SDE.demo.Services;


import com.SDE.demo.Enities.Secteur_Activite;

import java.util.List;
import java.util.Optional;

public interface Secteur_ActiviteService {
    Secteur_Activite ajouterSecteurActivite(Secteur_Activite secteurActivite);
    Secteur_Activite modifierSecteur_Activite(Secteur_Activite secteurActivite);
    void supprimerSecteurActivite(Secteur_Activite secteurActivite);
    List<Secteur_Activite> listesecteurActivite();
    void supprimerById(Long id);
    Optional<Secteur_Activite> getSecteurActiviteById(Long id);
}
