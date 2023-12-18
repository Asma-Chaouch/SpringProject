package com.SDE.demo.RestController;

import com.SDE.demo.Enities.*;
import com.SDE.demo.Repository.CandidatRepository;
import com.SDE.demo.Services.CandidatService;
import com.SDE.demo.Services.SpecialiteService;
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
@RequestMapping(value = "/candidat")
@CrossOrigin("*")
public class CandidatRestController {
    private CandidatRepository candidatRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public CandidatRestController(CandidatRepository candidatRepository){
        this.candidatRepository=candidatRepository;}
    @Autowired
    CandidatService candidatService;
    @Autowired
    SpecialiteService specialiteService;
    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> loginCandidat(@RequestBody Candidat candidat){
        //System.out.println("in login-Candidat"+candidat);
        HashMap<String,Object> response = new HashMap<>();
        Candidat candidatFromDB = candidatRepository.findEmailAndMpByEmail(candidat.getEmail());
        System.out.println("userfromdb+candidat"+candidatFromDB);
        if(candidatFromDB == null){
            response.put("message","candidat not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        else {
            boolean compare = this.bCryptPasswordEncoder.matches(candidat.getMp(),candidatFromDB.getMp());
            System.out.println("compare"+compare);
            if(!compare){
                response.put("message","candidat not found!");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            else{
                String token = Jwts.builder()
                        .claim("data",candidatFromDB)
                        .signWith(SignatureAlgorithm.HS256,"Secret")
                        .compact();
                response.put("token",token);
                System.out.println("succes");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        }
    }
@PostMapping(path = "register")
    public ResponseEntity<Candidat> addCandidat(@RequestBody Candidat candidat){
        candidat.setMp(this.bCryptPasswordEncoder.encode(candidat.getMp()));
        Candidat savedUser = candidatRepository.save(candidat);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
@RequestMapping(method = RequestMethod.POST)
    public Candidat ajouterCandidat(@RequestBody Candidat candidat){
    candidat.setMp(this.bCryptPasswordEncoder.encode(candidat.getMp()));
    Specialite specialite = specialiteService.ajouterSpecialite(candidat.getSpecialite());
    return candidatService.ajouterCandidat(candidat);
}
/*@PostMapping(path = "/{candidatId}/postuler/{offreId}")
public ResponseEntity<Candidature> postuler (@PathVariable Long candidatId , @PathVariable Long offreId , @RequestBody String cv){
        Candidature candidature= candidatService.postuler(candidatId,offreId,cv);
        return ResponseEntity.ok(candidature);
}*/
@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Candidat modifierCandidat(@PathVariable("id")Long id,@RequestBody Candidat candidat){
    Optional<Candidat> existingCandidat = candidatService.getCandidatById(id);

    // Vérifier si le mot de passe a été modifié
    if (!existingCandidat.get().getMp().equals(candidat.getMp())) {
        candidat.setMp(this.bCryptPasswordEncoder.encode(candidat.getMp()));
    }
    Specialite existingspecialite = specialiteService.modifierSpecialite(candidat.getSpecialite());
    Candidat newcandidat= candidatService.modifierCandidat(candidat,id);
    return newcandidat;
}
@RequestMapping(method = RequestMethod.GET)
    List<Candidat> listeCandidat() {

        return candidatService.listeCandidat();
}
@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public  void supprimerById(@PathVariable("id") long id){
        candidatService.supprimerById(id);
}
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Candidat> getCandidatWithDetails(@PathVariable("id") Long id) {
        Optional<Candidat> candidatOptional = candidatService.getCandidatById(id);
        Candidat candidat = candidatOptional.get();
        Optional<Specialite> specialiteOptional = specialiteService.getSpecialiteById(candidat.getSpecialite().getId());
        candidat.setSpecialite(specialiteOptional.orElse(null));
        return ResponseEntity.ok(candidat);
    }
}
