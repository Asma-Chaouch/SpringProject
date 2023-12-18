package com.SDE.demo.Services;

import com.SDE.demo.Enities.Adresse;
import com.SDE.demo.Enities.Entreprise;
import com.SDE.demo.Enities.Secteur_Activite;
import com.SDE.demo.Enities.Type_Entreprise;
import com.SDE.demo.Repository.AdresseRepository;
import com.SDE.demo.Repository.EntrepriseRepository;
import com.SDE.demo.Repository.Secteur_ActiviteRepository;
import com.SDE.demo.Repository.Type_EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepiseServiceImpl implements EntrepriseService{

@Autowired EntrepriseRepository entrepriseRepository;
    @Override
    public Entreprise ajouterEntreprise(Entreprise entreprise) {
        entreprise.setTypeEntreprise(entreprise.getTypeEntreprise());
        entreprise.setSecteurActivite(entreprise.getSecteurActivite());
        entreprise.setAdresse(entreprise.getAdresse());
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public Entreprise modifierEntreprise(Entreprise entreprise, Long id) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public List<Entreprise> listEntreprise() {
        return entrepriseRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        entrepriseRepository.deleteById(id);
    }

    @Override
    public Optional<Entreprise> getEntrepriseById(Long id) {
        return entrepriseRepository.findById(id);
    }
}
