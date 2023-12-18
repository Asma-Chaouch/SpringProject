package com.SDE.demo.Services;

import com.SDE.demo.Enities.Specialite;
import com.SDE.demo.Repository.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialiteServiceImpl implements SpecialiteService{
    @Autowired
    SpecialiteRepository specialiteRepository;
    @Override
    public Specialite ajouterSpecialite(Specialite specialite) {
        return specialiteRepository.save(specialite);
    }

    @Override
    public Specialite modifierSpecialite(Specialite specialite) {
        return specialiteRepository.save(specialite);
    }

    @Override
    public void supprimerSpecialite(Specialite specialite) {
        specialiteRepository.delete(specialite);

    }

    @Override
    public List<Specialite> listespecialite() {
        return specialiteRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        specialiteRepository.deleteById(id);

    }

    @Override
    public Optional<Specialite> getSpecialiteById(Long id) {
        return specialiteRepository.findById(id);
    }
}
