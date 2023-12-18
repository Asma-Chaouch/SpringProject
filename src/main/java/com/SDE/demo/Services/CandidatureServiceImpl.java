package com.SDE.demo.Services;

import com.SDE.demo.Enities.Candidat;
import com.SDE.demo.Enities.Candidature;
import com.SDE.demo.Enities.Offre;
import com.SDE.demo.Repository.CandidatRepository;
import com.SDE.demo.Repository.CandidatureRepository;
import com.SDE.demo.Repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CandidatureServiceImpl implements CandidatureService{
    @Autowired
    CandidatureRepository candidatureRepository;
    @Autowired
    CandidatRepository candidatRepository;
    @Autowired
    OffreRepository offreRepository;


    @Override
    public Candidature ajouterCandidature(Candidature candidature) {

        return candidatureRepository.save(candidature);
    }

    @Override
    public Candidature postuler(Long candidatId, Long offreId, String cvPath) {

            Optional<Candidat> candidat=candidatRepository.findById(candidatId);
            Optional<Offre> offre= offreRepository.findById(offreId);
            Candidature candidature = new Candidature();
            candidature.setCandidat(candidat.get());
            candidature.setOffre(offre.get());
            candidature.setCv(cvPath);
            return candidatureRepository.save(candidature);
    }


    @Override
    public Candidature modifierCandidature(Candidature candidature, Long id) {
        return candidatureRepository.save(candidature);
    }

    @Override
    public void supprimerCandidature(Candidature candidature) {
        candidatureRepository.delete(candidature);

    }


    @Override
    public List<Candidature> listeCandidature() {
        return candidatureRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        candidatureRepository.deleteById(id);

    }

    @Override
    public Optional<Candidature> getCandidatureById(Long id) {
        return candidatureRepository.findById(id);
    }
}
