package com.SDE.demo.Services;


import com.SDE.demo.Enities.Offre;

import java.util.List;
import java.util.Optional;

public interface OffreService {
    Offre ajouterOffre(Offre offre);
    Offre modifierOffre(Offre offre, Long id);
    void supprimerOffre(Offre offre);
    List<Offre> listeoffre();
    void supprimerById(Long id);
    Optional<Offre> getOffreById(Long id);
}
