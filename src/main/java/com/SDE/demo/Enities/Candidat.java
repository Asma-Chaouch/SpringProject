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
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String mp;
    private String telephone;
@   JsonIgnore
    @OneToMany(mappedBy = "candidat")
    private List<Candidature> candidatures;
    @ManyToOne
    @JsonIgnoreProperties
    private Specialite specialite;
    @JsonIgnore
    @OneToMany(mappedBy = "candidatcontact")
    private List<Contact> contactList;



}
