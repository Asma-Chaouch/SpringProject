package com.SDE.demo.RestController;

import com.SDE.demo.Enities.Candidat;
import com.SDE.demo.Enities.Contact;
import com.SDE.demo.Enities.Entreprise;
import com.SDE.demo.Repository.ContactRepository;
import com.SDE.demo.Services.CandidatService;
import com.SDE.demo.Services.ContactService;
import com.SDE.demo.Services.EmailService;
import com.SDE.demo.Services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/contact")
@CrossOrigin("*")
public class ContactRestController {
    @Autowired
    ContactService contactService;
    @Autowired
    CandidatService candidatService;
    @Autowired
    EntrepriseService entrepriseService;
    @RequestMapping(method = RequestMethod.POST, value = "/candidat/{idc}")
    public Contact ajouterContactparCandidat(@RequestBody Contact contact , @PathVariable("idc") Long id){
        Optional<Candidat> candidat = candidatService.getCandidatById(id);
        contact.setCandidatcontact(candidat.get());
        return contactService.ajouterContact(contact);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/entreprise/{ide}")
    public Contact ajouterContactparentreprise(@RequestBody Contact contact , @PathVariable("ide") Long id){
        Optional<Entreprise> entreprise = entrepriseService.getEntrepriseById(id);
        contact.setEntreprisecontact(entreprise.get());
        return contactService.ajouterContact(contact);
    }
    /*@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Contact modifierContact(@PathVariable("id")Long id,@RequestBody Contact contact){
        Contact newcontact=contactService.modifierContact(contact);
        return newcontact;
    }*/
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    EmailService emailService;
    @RequestMapping(value = "/candidat/{id}" , method = RequestMethod.PUT)
    public Contact modifierEtat(@PathVariable("id")Long id,@RequestBody  Contact contact){
        if(contactRepository.findById(id).isPresent()){
            Contact contact1=contactRepository.findById(id).get();
            if(contact.isEtat() != contact1.isEtat()){
                //ternary expression
                String etat = contact1.isEtat()? "Non traité" : "traité";
                emailService.sendSimpleMessage(contact1.getCandidatcontact().getEmail(),"L'etat de votre Contact","votre contact a été " +etat);
            }
            contact1.setEtat(contact.isEtat());
            Contact newContact=contactService.modifierContact(contact1,id);
            return newContact;
            //return entrepriseRepository.save(entreprise1);
        }
        return null;
    }
    @RequestMapping(value = "/entreprise/{id}" , method = RequestMethod.PUT)
    public Contact modifierEtatEntreprise(@PathVariable("id")Long id,@RequestBody  Contact contact){
        if(contactRepository.findById(id).isPresent()){
            Contact contact1=contactRepository.findById(id).get();
            if(contact.isEtat() != contact1.isEtat()){
                //ternary expression
                String etat = contact1.isEtat()? "Non traité" : "traité";
                emailService.sendSimpleMessage(contact1.getEntreprisecontact().getEmail(),"L'etat de votre Contact","votre contact a été " +etat);
            }
            contact1.setEtat(contact.isEtat());
            Contact newContact=contactService.modifierContact(contact1,id);
            return newContact;
            //return entrepriseRepository.save(entreprise1);
        }
        return null;
    }
    @RequestMapping(method = RequestMethod.GET)
    List<Contact> listecontact(){
        return contactService.listecontact();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void supprimerById(@PathVariable("id") long id){
        contactService.supprimerById(id);
    }
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public Long countAll() {
        return contactService.countById();
    }
}
