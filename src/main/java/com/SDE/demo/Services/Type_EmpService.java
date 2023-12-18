package com.SDE.demo.Services;

import com.SDE.demo.Enities.Offre;
import com.SDE.demo.Enities.Type_Emp;

import java.util.List;
import java.util.Optional;

public interface Type_EmpService {
    Type_Emp ajouterType_Emp(Type_Emp typeEmp);
    Type_Emp modifierType_Emp(Type_Emp typeEmp);
    void supprimerType_Emp(Type_Emp typeEmp);
    List<Type_Emp> listetypeEmp();
    void supprimerById(Long id);
    Optional<Type_Emp> getType_EmpById(Long id);
}
