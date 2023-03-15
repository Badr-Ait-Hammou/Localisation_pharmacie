package com.example.localisation_pharmacie.repository;

import com.example.localisation_pharmacie.entity.Garde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardeRepository extends JpaRepository<Garde,Integer> {
    Garde findById(int id);
}
