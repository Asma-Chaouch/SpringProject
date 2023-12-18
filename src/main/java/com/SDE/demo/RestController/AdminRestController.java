package com.SDE.demo.RestController;

import com.SDE.demo.Enities.Admin;
import com.SDE.demo.Repository.AdminRepository;
import com.SDE.demo.Services.AdminService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/admin")
@CrossOrigin("*")
public class AdminRestController {
    private AdminRepository adminRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public AdminRestController(AdminRepository adminRepository) {

        this.adminRepository = adminRepository;

    }

    @Autowired
    AdminService adminService;
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginAdmin(@RequestBody Admin admin) {
        System.out.println("in login-admin"+admin);
        HashMap<String, Object> response = new HashMap<>();

        Admin AdminFromDB = adminRepository.findAdminByEmail(admin.getEmail());
        System.out.println("userFromDB+admin"+AdminFromDB);
        if (AdminFromDB == null) {
            response.put("message", "Admin not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(admin.getMp(), AdminFromDB.getMp());
            System.out.println("compare"+compare);
            if (!compare) {
                response.put("message", "admin not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }else
            {
                String token = Jwts.builder()
                        .claim("data", AdminFromDB)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);
                System.out.println("hhh");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public Admin ajoutAdmin(@RequestBody Admin admin){
        admin.setMp(this.bCryptPasswordEncoder.encode(admin.getMp()));
        Admin savedUser = adminRepository.save(admin);

        return adminService.ajouterAdmin(admin);
    }
    /*@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Admin modifierAdmin(@PathVariable("id")Long id,@RequestBody Admin admin){
        admin.setMp(this.bCryptPasswordEncoder.encode(admin.getMp()));
        Admin newAdmin=adminService.modifierAdmin(admin);
        return newAdmin;
    }*/
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Admin modifierAdmin(@PathVariable("id") Long id, @RequestBody Admin admin) {
        Optional<Admin> existingAdmin = adminService.getAdminById(id);

        // Vérifier si le mot de passe a été modifié
        if (!existingAdmin.get().getMp().equals(admin.getMp())) {
            admin.setMp(this.bCryptPasswordEncoder.encode(admin.getMp()));
        }

        Admin newAdmin = adminService.modifierAdmin(admin);
        return newAdmin;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Admin> listeadmin(){
        return adminService.listeadmin();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        adminService.supprimerById(id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Admin> getAdminById(@PathVariable("id") long id){
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin;
    }
}

