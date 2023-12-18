package com.SDE.demo.Services;

import com.SDE.demo.Enities.Type_Entreprise;
import com.SDE.demo.Repository.Type_EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Type_EntrepriseServiceImpl implements Type_EntrepriseService{
    @Autowired
    Type_EntrepriseRepository typeEntrepriseRepository;

    @Override
    public Type_Entreprise ajouterType_Entreprise(Type_Entreprise typeEntreprise) {
        return typeEntrepriseRepository.save(typeEntreprise);
    }

    @Override
    public Type_Entreprise modifierType_Entreprise(Type_Entreprise typeEntreprise) {
        return typeEntrepriseRepository.save(typeEntreprise);
    }

    @Override
    public void supprimerType_Entreprise(Type_Entreprise typeEntreprise) {
        typeEntrepriseRepository.delete(typeEntreprise);

    }

    @Override
    public List<Type_Entreprise> listetypeEntreprise() {
        return typeEntrepriseRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        typeEntrepriseRepository.deleteById(id);

    }

    @Override
    public Optional<Type_Entreprise> getType_EntrepriseById(Long id) {
        return typeEntrepriseRepository.findById(id);
    }
}
