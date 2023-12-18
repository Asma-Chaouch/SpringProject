package com.SDE.demo.Services;


import com.SDE.demo.Enities.Lieu;

import java.util.List;
import java.util.Optional;

public interface LieuService {
    Lieu ajouterLieu(Lieu lieu);
    Lieu modifierLieu(Lieu lieu,Long id);
    List<Lieu> listeLieu();

    void supprimerById(Long id);
    Optional<Lieu> getLieuById(Long id);
}
