package com.SDE.demo.Enities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonIgnoreProperties
    private Candidat candidat;
    @ManyToOne
    @JsonIgnoreProperties
    private Offre offre;
    @Lob
    private String cv;
    @Column(name="etatCandidature",columnDefinition = "boolean default false")
    private boolean etatCandidature;
    @Column(name = "etatDownload",columnDefinition = "boolean default false")
    private  boolean etatDownload;
    /*@Transient
    public Long getOffreId() {
            return offre.getId();
    }
    @Transient
    @Column(name = "ofid")
    public String getOffretitre() {
        return offre.getTitre().getTitreE();
    }

    @Transient
    @Column(name = "canid")
    public Long getCANId() {
        return candidat.getId();
    }
    @Transient
    public String getNom() {
        return candidat.getNom();
    }
    public void setOffreId(Long offreId) {
        Offre offre = new Offre();
        offre.setId(offreId);
        this.offre = offre;
    }

    public void setOffretitre(String offreTitre) {
        Titre titre = new Titre();
        titre.setTitreE(offreTitre);
        Offre offre = new Offre();
        offre.setTitre(titre);
        this.offre = offre;
    }

    // Add setter for Candidat ID
    public void setCANId(Long candidatId) {
        Candidat candidat = new Candidat();
        candidat.setId(candidatId);
        this.candidat = candidat;
    }

    // Add setter for Candidat name
    public void setNom(String candidatNom) {
        Candidat candidat = new Candidat();
        candidat.setNom(candidatNom);
        this.candidat = candidat;
    }*/



}
