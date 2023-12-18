package com.SDE.demo.Services;


import com.SDE.demo.Enities.Offre;
import com.SDE.demo.Repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OffreServiceImpl implements OffreService {
    @Autowired
    OffreRepository offreRepository;

    @Override
    public Offre ajouterOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public Offre modifierOffre(Offre offre, Long id) {
        return offreRepository.save(offre);
    }
    @Override
    public void supprimerOffre(Offre offre) {
        offreRepository.delete(offre);

    }

    @Override
    public List<Offre> listeoffre() {
        return offreRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        offreRepository.deleteById(id);
    }

    @Override
    public Optional<Offre> getOffreById(Long id) {
        return offreRepository.findById(id);
    }
}

