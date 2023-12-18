package com.SDE.demo.Enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Type_Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @JsonIgnore
    @OneToMany(mappedBy = "typeEmp")
    private List<Offre> offreList;
}
