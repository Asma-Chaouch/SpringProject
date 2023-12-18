package com.SDE.demo.Services;

import com.SDE.demo.Enities.Titre;
import com.SDE.demo.Repository.TitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitreServiceImpl implements TitreService{
    @Autowired
    TitreRepository titreRepository;
    @Override
    public Titre ajouterTitre(Titre titre) {
        return titreRepository.save(titre);
    }

    @Override
    public Titre modifierTitre(Titre titre) {
        return titreRepository.save(titre);
    }

    @Override
    public void supprimerTitre(Titre titre) {
        titreRepository.delete(titre);

    }

    @Override
    public List<Titre> listetitre() {
        return titreRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        titreRepository.deleteById(id);

    }

    @Override
    public Optional<Titre> getTitreById(Long id) {
        return titreRepository.findById(id);
    }
}
