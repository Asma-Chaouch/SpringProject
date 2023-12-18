package com.SDE.demo.Services;

import com.SDE.demo.Enities.Domaine;
import com.SDE.demo.Repository.DomaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DomaineServiceImpl implements DomaineService{
    @Autowired
    DomaineRepository domaineRepository;
    @Override
    public Domaine ajouterDomaine(Domaine domaine) {
        return domaineRepository.save(domaine);
    }

    @Override
    public Domaine modifierDomaine(Domaine domaine) {
        return domaineRepository.save(domaine);
    }

    @Override
    public void supprimerDomaine(Domaine domaine) {
        domaineRepository.delete(domaine);

    }

    @Override
    public List<Domaine> listeDomaine() {
        return domaineRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        domaineRepository.deleteById(id);

    }

    @Override
    public Optional<Domaine> getDomaineById(Long id) {
        return domaineRepository.findById(id);
    }
}
