package com.example.localisation_pharmacie.repository;

import com.example.localisation_pharmacie.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville,Integer> {
    Ville findById(int id);


}
