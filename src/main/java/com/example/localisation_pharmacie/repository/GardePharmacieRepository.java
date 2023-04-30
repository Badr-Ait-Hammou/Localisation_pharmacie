package com.example.localisation_pharmacie.repository;

import com.example.localisation_pharmacie.entity.GardePharmacie;
import com.example.localisation_pharmacie.entity.Garde_PharmacyPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardePharmacieRepository extends JpaRepository<GardePharmacie,Integer> {
    GardePharmacie findById(int id);

}
