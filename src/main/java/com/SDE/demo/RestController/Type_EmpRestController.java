package com.SDE.demo.RestController;

import com.SDE.demo.Enities.Type_Emp;
import com.SDE.demo.Repository.Type_EmpRepository;
import com.SDE.demo.Services.Type_EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/typeEmp")
@CrossOrigin("*")
public class Type_EmpRestController {
    private Type_EmpRepository typeEmpRepository;

    @Autowired
    public Type_EmpRestController(Type_EmpRepository typeEmpRepository) {

        this.typeEmpRepository = typeEmpRepository;

    }
    @Autowired
    Type_EmpService typeEmpService;
    @RequestMapping(method = RequestMethod.POST)
    public Type_Emp ajoutType_Emp(@RequestBody Type_Emp typeEmp){

        Type_Emp savedUser = typeEmpRepository.save(typeEmp);

        return typeEmpService.ajouterType_Emp(typeEmp);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Type_Emp modifierType_Emp(@PathVariable("id")Long id,@RequestBody Type_Emp typeEmp){
        Type_Emp newType_Emp=typeEmpService.modifierType_Emp(typeEmp);
        return newType_Emp;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Type_Emp> listetypeEmp(){
        return typeEmpService.listetypeEmp();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        typeEmpService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Type_Emp> getType_EmpById(@PathVariable("id") long id){
        Optional<Type_Emp> typeEmp = typeEmpService.getType_EmpById(id);
        return typeEmp;
    }
}
