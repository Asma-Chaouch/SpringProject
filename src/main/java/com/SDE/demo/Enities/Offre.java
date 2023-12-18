package com.SDE.demo.Enities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer posteVac;/*************/
    private Integer experience;
    private String dateexp;
    private String exigences;
    private String description;


    @JsonIgnore
    @OneToMany(mappedBy = "offre")
    private List<Candidature> candidatures;

    @ManyToOne
    @JsonIgnoreProperties
    private Domaine domaine;
    @ManyToOne
    @JsonIgnoreProperties
    private Type_Emp typeEmp;
    @ManyToOne
    @JsonIgnoreProperties
    private Niveau_Etude niveauEtude;
    @ManyToOne
    @JsonIgnoreProperties
    private Titre titre;
    @ManyToOne
    @JsonIgnoreProperties
    private Lieu lieu;
    @ManyToOne
    @JsonIgnoreProperties
    private Entreprise entreprise;
    //@ManyToOne
    //@JsonIgnoreProperties
   // private Categorie categorie;/*************/


}
