package com.SDE.demo.Services;

import com.SDE.demo.Enities.Lieu;
import com.SDE.demo.Repository.LieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LieuServiceImpl implements LieuService{
    @Autowired
    LieuRepository lieuRepository;

    @Override
    public Lieu ajouterLieu(Lieu lieu) {
        return lieuRepository.save(lieu);
    }

    @Override
    public Lieu modifierLieu(Lieu lieu, Long id) {
        return lieuRepository.save(lieu);
    }

    @Override
    public List<Lieu> listeLieu() {
        return lieuRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        lieuRepository.deleteById(id);

    }

    @Override
    public Optional<Lieu> getLieuById(Long id) {
        return lieuRepository.findById(id);
    }
}
