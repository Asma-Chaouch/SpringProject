package com.SDE.demo.Enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    private String email;
    private String mp;
    private String telephone;
    @Lob
    private String logo;
    private boolean etat;
    @Lob
    private String cv;
    private String description;
    private String annedefondation;
    private String site;
    private  Integer nbemployee;

   @ManyToOne
   @JsonIgnoreProperties
    private Secteur_Activite secteurActivite;

    @ManyToOne
    @JsonIgnoreProperties
    private Type_Entreprise typeEntreprise;

    @ManyToOne
    @JsonIgnoreProperties
    private Adresse adresse;
    @JsonIgnore
    @OneToMany(mappedBy = "entreprise")
    private List<Offre> entrepriseOffre;

    @JsonIgnore
    @OneToMany(mappedBy = "entreprisecontact")
    private List<Contact> contactList;

}
