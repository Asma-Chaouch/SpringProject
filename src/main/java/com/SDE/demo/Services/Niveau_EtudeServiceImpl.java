package com.SDE.demo.Services;

import com.SDE.demo.Enities.Niveau_Etude;
import com.SDE.demo.Repository.Niveau_EtudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Niveau_EtudeServiceImpl implements Niveau_EtudeService{
    @Autowired
    Niveau_EtudeRepository niveauEtudeRepository;
    @Override
    public Niveau_Etude ajouterNiveauEtude(Niveau_Etude niveauEtude) {
        return niveauEtudeRepository.save(niveauEtude);
    }

    @Override
    public Niveau_Etude modifierNiveauEtude(Niveau_Etude niveauEtude, Long id) {
        return niveauEtudeRepository.save(niveauEtude);
    }

    @Override
    public List<Niveau_Etude> listeNiveauEtude() {
        return niveauEtudeRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        niveauEtudeRepository.deleteById(id);

    }

    @Override
    public Optional<Niveau_Etude> getNiveauEtudeById(Long id) {
        return niveauEtudeRepository.findById(id);
    }
}
