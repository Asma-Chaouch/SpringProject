package com.SDE.demo.RestController;

import com.SDE.demo.Enities.*;
import com.SDE.demo.Repository.AdresseRepository;
import com.SDE.demo.Repository.EntrepriseRepository;
import com.SDE.demo.Repository.Secteur_ActiviteRepository;
import com.SDE.demo.Repository.Type_EntrepriseRepository;
import com.SDE.demo.Services.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/entreprise")
@CrossOrigin("*")
public class EntrepriseRestController {
    private EntrepriseRepository entrepriseRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
    @Autowired
    public  EntrepriseRestController(EntrepriseRepository entrepriseRepository){
        this.entrepriseRepository=entrepriseRepository;
    }

    @Autowired
    EntrepriseService entrepriseService;
    @Autowired
    AdresseService adresseService;
    @Autowired
    Secteur_ActiviteService secteurActiviteService;
    @Autowired
    Type_EntrepriseService typeEntrepriseService;
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginEntreprise(@RequestBody Entreprise entreprise) {
        //System.out.println("in login-entreprise"+entreprise);
        HashMap<String, Object> response = new HashMap<>();

        Entreprise entrepriseFromDB = entrepriseRepository.findEmailAndMpByEmail(entreprise.getEmail());
        //System.out.println("userFromDB+admin"+entrepriseFromDB);
        if (entrepriseFromDB == null) {
            response.put("message", "Admin not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            if (!entrepriseFromDB.isEtat()) {
                response.put("message", "Votre Compte est bloqu& !");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            } else {
                String token = Jwts.builder()
                        .claim("data", entrepriseFromDB)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);
                System.out.println("hhh");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }
    }

    @PostMapping(path = "register")
    public ResponseEntity<Entreprise> addEntreprise(@RequestBody Entreprise entreprise) {

        entreprise.setMp(this.bCryptPasswordEncoder.encode(entreprise.getMp()));
        Entreprise savedUser = entrepriseRepository.save(entreprise);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

   @Autowired
    Secteur_ActiviteRepository secteurActiviteRepository;
    @Autowired
    Type_EntrepriseRepository typeEntrepriseRepository;
    @Autowired
    AdresseRepository adresseRepository;
   /* @RequestMapping(method = RequestMethod.POST)
    public Entreprise ajouterEntreprise(@RequestBody Entreprise entreprise) {
        entreprise.setMp(this.bCryptPasswordEncoder.encode(entreprise.getMp()));
        Adresse adresse = adresseService.ajouterAdresse(entreprise.getAdresse());
        Secteur_Activite secteurActivite = secteurActiviteService.ajouterSecteurActivite(entreprise.getSecteurActivite());
        Type_Entreprise typeEntreprise = typeEntrepriseService.ajouterType_Entreprise(entreprise.getTypeEntreprise());
        return entrepriseService.ajouterEntreprise(entreprise);
    }*/
   /*@PostMapping
   public ResponseEntity<String> ajouterEntreprise(@RequestBody Entreprise entrepriseDTO) {
       // Create instances of entities
       Entreprise entreprise = new Entreprise();
       Adresse adresse = new Adresse();
       Secteur_Activite secteurActivite = new Secteur_Activite();
       Type_Entreprise typeEntreprise = new Type_Entreprise();

       // Set values from DTO to entities
       entreprise.setNom(entrepriseDTO.getNom());
       entreprise.setEmail(entrepriseDTO.getEmail());
       entreprise.setMp(entrepriseDTO.getMp());
       entreprise.setTelephone(entrepriseDTO.getTelephone());
       entreprise.setLogo(entrepriseDTO.getLogo());
       entreprise.setCv(entrepriseDTO.getCv());
       entreprise.setDescription(entrepriseDTO.getDescription());
       entreprise.setAnnedefondation(entrepriseDTO.getAnnedefondation());
       entreprise.setSite(entrepriseDTO.getSite());
       entreprise.setNbemployee(entrepriseDTO.getNbemployee());
       adresseService.ajouterAdresse(adresse);
       adresse.setCode_postal(entrepriseDTO.getAdresse().getCode_postal());
       adresse.setVille(entrepriseDTO.getAdresse().getVille());
       adresse.setRue(entrepriseDTO.getAdresse().getRue());
       secteurActiviteService.ajouterSecteurActivite(secteurActivite);
       secteurActivite.setNom_secteur(entrepriseDTO.getSecteurActivite().getNom_secteur());
       typeEntrepriseService.ajouterType_Entreprise(typeEntreprise);
       typeEntreprise.setType(entrepriseDTO.getTypeEntreprise().getType());
       // Set relationships
       entreprise.setAdresse(adresse);
       entreprise.setSecteurActivite(secteurActivite);
       entreprise.setTypeEntreprise(typeEntreprise);
       // Save entities
       entrepriseService.ajouterEntreprise(entreprise);

       return ResponseEntity.ok("Entreprise added successfully.");
   }*/
   /*@PostMapping
   public ResponseEntity<String> ajouterEntreprise(@RequestBody Entreprise entrepriseDTO) {
       // Create instances of entities
       Entreprise entreprise = new Entreprise();
       Adresse adresse = new Adresse();
       Secteur_Activite secteurActivite = new Secteur_Activite();
       Type_Entreprise typeEntreprise = new Type_Entreprise();

       // Set values from DTO to entities
       entreprise.setNom(entrepriseDTO.getNom());
       entreprise.setEmail(entrepriseDTO.getEmail());
       entreprise.setMp(entrepriseDTO.getMp());
       entreprise.setTelephone(entrepriseDTO.getTelephone());
       entreprise.setLogo(entrepriseDTO.getLogo());
       entreprise.setCv(entrepriseDTO.getCv());
       entreprise.setDescription(entrepriseDTO.getDescription());
       entreprise.setAnnedefondation(entrepriseDTO.getAnnedefondation());
       entreprise.setSite(entrepriseDTO.getSite());
       entreprise.setNbemployee(entrepriseDTO.getNbemployee());

       // Set relationships
       entreprise.setAdresse(adresse);
       entreprise.setSecteurActivite(secteurActivite);
       entreprise.setTypeEntreprise(typeEntreprise);

       // Save related entities
       adresse.setCode_postal(entrepriseDTO.getAdresse().getCode_postal());
       adresse.setVille(entrepriseDTO.getAdresse().getVille());
       adresse.setRue(entrepriseDTO.getAdresse().getRue());

       secteurActivite.setNom_secteur(entrepriseDTO.getSecteurActivite().getNom_secteur());

       typeEntreprise.setType(entrepriseDTO.getTypeEntreprise().getType());

       // Save entities
       adresseService.ajouterAdresse(adresse);
       secteurActiviteService.ajouterSecteurActivite(secteurActivite);
       typeEntrepriseService.ajouterType_Entreprise(typeEntreprise);
       entrepriseService.ajouterEntreprise(entreprise);

       return ResponseEntity.ok("Entreprise added successfully.");
   }*/
 /*  @PostMapping
   public Entreprise ajouterEntreprise(@RequestBody Entreprise entrepriseDTO) {
       System.out.println(entrepriseDTO.getAdresse());

       adresseService.ajouterAdresse(entrepriseDTO.getAdresse());
       secteurActiviteService.ajouterSecteurActivite(entrepriseDTO.getSecteurActivite());
       typeEntrepriseService.ajouterType_Entreprise(entrepriseDTO.getTypeEntreprise());
       return entrepriseService.ajouterEntreprise(entrepriseDTO);

   }*/
   @RequestMapping(method = RequestMethod.POST)
   public ResponseEntity<?> ajouterentreprise(@RequestBody Entreprise entreprise) {
       if (entrepriseRepository.existsByEmail(entreprise.getEmail())) {
           return new ResponseEntity<Void>(HttpStatus.FOUND);
       } else {
           entreprise.setMp(this.bCryptPasswordEncoder.encode(entreprise.getMp()));
           Adresse adresse = adresseService.ajouterAdresse(entreprise.getAdresse());
           Secteur_Activite secteurActivite = secteurActiviteService.ajouterSecteurActivite(entreprise.getSecteurActivite());
           Type_Entreprise typeEntreprise = typeEntrepriseService.ajouterType_Entreprise(entreprise.getTypeEntreprise());
           Entreprise savedUser = entrepriseService.ajouterEntreprise(entreprise);
           return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
       }
   }


    @RequestMapping(method = RequestMethod.GET)
    public List<Entreprise> listeentreprise(){

        return entrepriseService.listEntreprise();
    }


 /* @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Entreprise modifierEntreprise(@PathVariable("id")Long id,@RequestBody Entreprise entreprise){
      Adresse existingAdresse = adresseService.modifierAdresse(entreprise.getAdresse());
      Type_Entreprise existingtype = typeEntrepriseService.modifierType_Entreprise(entreprise.getTypeEntreprise());
      Secteur_Activite existsecteur = secteurActiviteService.modifierSecteur_Activite(entreprise.getSecteurActivite());
      Entreprise existingEntreprise= entrepriseService.modifierEntreprise(entreprise,id);
      return existingEntreprise;
  }*/
  @Autowired
    EmailService emailService;
    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public Entreprise modifierEntreprise(@PathVariable("id")Long id,@RequestBody  Entreprise entreprise){
        if(entrepriseRepository.findById(id).isPresent()){
            Entreprise entreprise1=entrepriseRepository.findById(id).get();
            entreprise1.setNom(entreprise.getNom());
            entreprise1.setAdresse(entreprise.getAdresse());
            entreprise1.setEmail(entreprise.getEmail());
            entreprise.setMp(this.bCryptPasswordEncoder.encode(entreprise1.getMp()));
            entreprise1.setTelephone(entreprise.getTelephone());
            entreprise1.setCv(entreprise.getCv());
            entreprise1.setLogo(entreprise.getLogo());
            entreprise1.setTypeEntreprise(entreprise.getTypeEntreprise());
            entreprise1.setAdresse(entreprise.getAdresse());
            entreprise1.setSecteurActivite(entreprise.getSecteurActivite());
            if(entreprise.isEtat() != entreprise1.isEtat()){
                //ternary expression
                String etat = entreprise1.isEtat()? "blouqué" : "Acceptée";
                emailService.sendSimpleMessage(entreprise1.getEmail(),entreprise1.getNom()+"L'etat de votre compte","votre compte a été " +etat);
            }
            entreprise1.setEtat(entreprise.isEtat());
            Adresse existingAdresse = adresseService.modifierAdresse(entreprise.getAdresse());
            Type_Entreprise existingtype = typeEntrepriseService.modifierType_Entreprise(entreprise.getTypeEntreprise());
            Secteur_Activite existsecteur = secteurActiviteService.modifierSecteur_Activite(entreprise.getSecteurActivite());
            Entreprise existingEntreprise= entrepriseService.modifierEntreprise(entreprise,id);
            return existingEntreprise;
        }
        return null;
    }




    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        entrepriseService.supprimerById(id);
    }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public ResponseEntity<Entreprise> getEntrepriseWithDetails(@PathVariable("id") Long id) {
       Optional<Entreprise> entrepriseOptional = entrepriseService.getEntrepriseById(id);

       Entreprise entreprise = entrepriseOptional.get();
       Optional<Adresse> adresseOptional = adresseService.getAdresseById(entreprise.getAdresse().getId());
       Optional<Type_Entreprise> typeEntrepriseOptional = typeEntrepriseService.getType_EntrepriseById(entreprise.getTypeEntreprise().getId());
       Optional<Secteur_Activite> secteurActiviteOptional = secteurActiviteService.getSecteurActiviteById(entreprise.getSecteurActivite().getId());
       entreprise.setAdresse(adresseOptional.orElse(null));
       entreprise.setTypeEntreprise(typeEntrepriseOptional.orElse(null));
       entreprise.setSecteurActivite(secteurActiviteOptional.orElse(null));
       return ResponseEntity.ok(entreprise);
   }
}


