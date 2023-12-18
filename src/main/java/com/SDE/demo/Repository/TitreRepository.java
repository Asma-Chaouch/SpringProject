package com.SDE.demo.Repository;


import com.SDE.demo.Enities.Titre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitreRepository extends JpaRepository<Titre,Long> {
}
