package com.SDE.demo.Services;

import com.SDE.demo.Enities.Adresse;
import com.SDE.demo.Repository.AdminRepository;
import com.SDE.demo.Repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdresseServiceImpl implements AdresseService{
    @Autowired
    AdresseRepository adresseRepository;
    @Override
    public Adresse ajouterAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public Adresse modifierAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public void supprimerAdresse(Adresse adresse) {
        adresseRepository.delete(adresse);

    }

    @Override
    public List<Adresse> listeadresse() {
        return adresseRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        adresseRepository.deleteById(id);

    }

    @Override
    public Optional<Adresse> getAdresseById(Long id) {
        return adresseRepository.findById(id);
    }
}
