package com.example.localisation_pharmacie.repository;

import com.example.localisation_pharmacie.entity.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie,Integer> {
    Pharmacie findById(int id);
    List<Pharmacie> findByZoneId(int id);

    int deleteByZoneId(int id);
}
