package com.SDE.demo.Enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Titre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titreE;
    @JsonIgnore
    @OneToMany(mappedBy = "titre")
    private List<Offre> offreList;
}
