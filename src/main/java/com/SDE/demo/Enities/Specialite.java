package com.SDE.demo.Enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomspecialite;
    @JsonIgnore
    @OneToMany(mappedBy = "specialite")
    private List<Candidat> candidatList;
}
