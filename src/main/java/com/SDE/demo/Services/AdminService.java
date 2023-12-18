package com.SDE.demo.Services;

import com.SDE.demo.Enities.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin ajouterAdmin(Admin admin);
    Admin modifierAdmin(Admin admin);
    void supprimerAdmin(Admin admin);
    List<Admin> listeadmin();
    void supprimerById(Long id);
    Optional<Admin> getAdminById(Long id);
}
