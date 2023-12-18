package com.SDE.demo.Repository;

import com.SDE.demo.Enities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {
   // @Query("SELECT e.email, e.mp , e.id , e.etat FROM Entreprise e WHERE e.email = :email")
    Entreprise findEmailAndMpByEmail(@Param("email") String email);
    boolean existsByEmail(String email);
    //List<Entreprise> findAll();
    //@Query("SELECT e, a, t, s FROM Entreprise e JOIN e.adresse a JOIN e.typeEntreprise t JOIN e.secteurActivite s")
    //List<Object[]> listEntrepriseWithAdresseTypeAndSecteur();
    //@Query("SELECT e FROM Entreprise e LEFT JOIN FETCH e.adresse")
   // List<Entreprise> findAllWithAdresse();
}
