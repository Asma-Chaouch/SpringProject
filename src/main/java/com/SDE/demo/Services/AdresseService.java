package com.SDE.demo.Services;


import com.SDE.demo.Enities.Adresse;

import java.util.List;
import java.util.Optional;

public interface AdresseService {
    Adresse ajouterAdresse(Adresse adresse);
    Adresse modifierAdresse(Adresse adresse);
    void supprimerAdresse(Adresse adresse);
    List<Adresse> listeadresse();
    void supprimerById(Long id);
    Optional<Adresse> getAdresseById(Long id);
}

