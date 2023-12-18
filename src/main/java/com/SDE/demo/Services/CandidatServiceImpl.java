package com.SDE.demo.Services;

import com.SDE.demo.Enities.Candidat;

import com.SDE.demo.Enities.Offre;
import com.SDE.demo.Repository.CandidatRepository;
import com.SDE.demo.Repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CandidatServiceImpl implements CandidatService{
    @Autowired
    CandidatRepository candidatRepository;
    @Autowired
    OffreRepository offreRepository;

    @Override
    public Candidat ajouterCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    @Override
    public Candidat modifierCandidat(Candidat candidat, Long id) {
        return candidatRepository.save(candidat);
    }

  /*  @Override
    public Candidature postuler(Long candidatId, Long offreId, String cv) {
        Optional<Candidat> candidat=candidatRepository.findById(candidatId);
        Optional<Offre> offre= offreRepository.findById(offreId);
        Candidature candidature = new Candidature();
        candidature.setCandidat(candidat.get());
        candidature.setOffre(offre.get());
        candidature.setCv(cv);
        candidat.get().getCandidatures().add(candidature);
        offre.get().getCandidatures().add(candidature);
        return candidatureRepository.save(candidature);
    }*/

    @Override
    public void supprimerCandidat(Candidat candidat) {
        candidatRepository.delete(candidat);

    }

    @Override
    public List<Candidat> listeCandidat() {
        return candidatRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        candidatRepository.deleteById(id);
    }

    @Override
    public Optional<Candidat> getCandidatById(Long id) {
        return candidatRepository.findById(id);
    }
}

