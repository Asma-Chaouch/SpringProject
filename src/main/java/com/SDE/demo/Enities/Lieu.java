package com.SDE.demo.Enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Lieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer code_postal;
    private String ville;
    private String gouvernement;
    @JsonIgnore
    @OneToMany(mappedBy = "lieu")
    private List<Offre> offreList;
}
