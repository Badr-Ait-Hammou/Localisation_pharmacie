package com.example.localisation_pharmacie.repository;

import com.example.localisation_pharmacie.entity.Garde_Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardePharmacieRepository extends JpaRepository<Garde_Pharmacie,Integer> {
    Garde_Pharmacie findById(int id);
}
