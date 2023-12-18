package com.SDE.demo.Repository;

import com.SDE.demo.Enities.Lieu;
import com.SDE.demo.Enities.Niveau_Etude;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Niveau_EtudeRepository extends JpaRepository<Niveau_Etude,Long> {
}
