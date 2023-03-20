package com.example.localisation_pharmacie.repository;

import com.example.localisation_pharmacie.entity.Pharmacie;
import com.example.localisation_pharmacie.entity.Ville;
import com.example.localisation_pharmacie.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer> {
    Zone findById(int id);
   // Ville findVilleByzone(int id);
   @Query("select z.nom from Zone z where z.ville.nom=:nom order by z.nom")
   List<Zone> findZoneByVille(@Param("nom")String nom);
}
