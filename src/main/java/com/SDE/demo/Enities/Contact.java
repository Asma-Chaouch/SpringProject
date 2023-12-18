package com.SDE.demo.Enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sujet;
    private String Description;
    private  boolean etat;
    @ManyToOne
    @JsonIgnoreProperties
    private Entreprise entreprisecontact;

    @ManyToOne
    @JsonIgnoreProperties
    private Candidat candidatcontact;



}
