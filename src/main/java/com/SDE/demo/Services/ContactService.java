package com.SDE.demo.Services;

import com.SDE.demo.Enities.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact ajouterContact(Contact contact);
    Contact modifierContact(Contact contact,Long id);
    void supprimerContact(Contact contact);
    List<Contact> listecontact();
    void supprimerById(Long id);
    Optional<Contact> getContactById(Long id);
    long countById();
}
