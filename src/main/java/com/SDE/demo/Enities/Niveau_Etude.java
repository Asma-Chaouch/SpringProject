package com.SDE.demo.Enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
    @Data

    public class Niveau_Etude {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String niveau;
    @JsonIgnore
    @OneToMany(mappedBy = "niveauEtude")
    private List<Offre> offreList;
    }
