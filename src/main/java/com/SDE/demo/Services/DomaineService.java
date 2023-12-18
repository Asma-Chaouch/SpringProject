package com.SDE.demo.Services;

import com.SDE.demo.Enities.Domaine;

import java.util.List;
import java.util.Optional;

public interface DomaineService {
    Domaine ajouterDomaine(Domaine domaine);
    Domaine modifierDomaine(Domaine domaine);
    void supprimerDomaine(Domaine domaine);
    List<Domaine> listeDomaine();
    void supprimerById(Long id);
    Optional<Domaine> getDomaineById(Long id);
}
