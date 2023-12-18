package com.SDE.demo.Services;

import com.SDE.demo.Enities.Secteur_Activite;
import com.SDE.demo.Repository.Secteur_ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Secteur_AcitiviteServiceImpl implements Secteur_ActiviteService{
    @Autowired
    Secteur_ActiviteRepository secteurActiviteRepository;
    @Override
    public Secteur_Activite ajouterSecteurActivite(Secteur_Activite secteurActivite) {
        return secteurActiviteRepository.save(secteurActivite);
    }

    @Override
    public Secteur_Activite modifierSecteur_Activite(Secteur_Activite secteurActivite) {
        return secteurActiviteRepository.save(secteurActivite);
    }

    @Override
    public void supprimerSecteurActivite(Secteur_Activite secteurActivite) {
        secteurActiviteRepository.save(secteurActivite);

    }

    @Override
    public List<Secteur_Activite> listesecteurActivite() {
        return secteurActiviteRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        secteurActiviteRepository.deleteById(id);

    }

    @Override
    public Optional<Secteur_Activite> getSecteurActiviteById(Long id) {
        return secteurActiviteRepository.findById(id);
    }
}
