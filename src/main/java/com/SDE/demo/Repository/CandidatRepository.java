package com.SDE.demo.Repository;

import com.SDE.demo.Enities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidatRepository extends JpaRepository<Candidat,Long> {

    //@Query("SELECT e.email, e.mp , e.id FROM Candidat e WHERE e.email = :email")
    Candidat findEmailAndMpByEmail(@Param("email") String email);
}
