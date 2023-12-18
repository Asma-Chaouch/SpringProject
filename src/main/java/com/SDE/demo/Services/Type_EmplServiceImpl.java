package com.SDE.demo.Services;

import com.SDE.demo.Enities.Type_Emp;
import com.SDE.demo.Repository.Type_EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Type_EmplServiceImpl implements Type_EmpService{
    @Autowired
    Type_EmpRepository typeEmpRepository;
    @Override
    public Type_Emp ajouterType_Emp(Type_Emp typeEmp) {
        return typeEmpRepository.save(typeEmp);
    }

    @Override
    public Type_Emp modifierType_Emp(Type_Emp typeEmp) {
        return typeEmpRepository.save(typeEmp);
    }

    @Override
    public void supprimerType_Emp(Type_Emp typeEmp) {
        typeEmpRepository.delete(typeEmp);

    }

    @Override
    public List<Type_Emp> listetypeEmp() {
        return typeEmpRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        typeEmpRepository.deleteById(id);

    }

    @Override
    public Optional<Type_Emp> getType_EmpById(Long id) {
        return typeEmpRepository.findById(id);
    }
}
