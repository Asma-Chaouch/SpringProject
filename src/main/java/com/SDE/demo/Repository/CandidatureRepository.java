package com.SDE.demo.Repository;

import com.SDE.demo.Enities.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidatureRepository extends JpaRepository<Candidature,Long> {
    /*@Modifying
    @Query("UPDATE Candidature c SET c.etatCandidature = :etat WHERE c.id = :id")
    int updateEtatById(@Param("etat") boolean etat, @Param("id") Long id);*/
}
