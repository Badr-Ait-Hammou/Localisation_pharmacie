package com.example.localisation_pharmacie.repository;

import com.example.localisation_pharmacie.entity.Pharmacie;
import com.example.localisation_pharmacie.entity.Ville;
import com.example.localisation_pharmacie.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer> {
    Zone findById(int id);
   // Ville findVilleByzone(int id);
}
