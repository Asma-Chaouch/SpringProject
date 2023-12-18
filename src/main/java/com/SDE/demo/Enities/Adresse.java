package com.SDE.demo.Enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
    @Data
    public class Adresse {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Integer code_postal;
        private String ville;
        private String rue;


         @JsonIgnore
         @OneToMany(mappedBy = "adresse")
         private List<Entreprise> entrepriseList;
    /*public Adresse() {
        // initialize to empty list in constructor
        this.entrepriseList = new ArrayList<>();
    }*/
    }


