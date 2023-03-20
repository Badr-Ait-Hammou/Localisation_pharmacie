package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.Garde_Pharmacie;
import com.example.localisation_pharmacie.repository.GardePharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GardPharmacieService implements IDao<Garde_Pharmacie> {

    @Autowired
    private GardePharmacieRepository gardePharmacieRepository;

    @Override
    public Garde_Pharmacie save(Garde_Pharmacie o) {
        return gardePharmacieRepository.save(o);
    }

    @Override
    public List<Garde_Pharmacie> findAll() {
        return gardePharmacieRepository.findAll();
    }

    @Override
    public Garde_Pharmacie findById(int id) {
        return gardePharmacieRepository.findById(id);
    }

    @Override
    public void update(Garde_Pharmacie o) {
            gardePharmacieRepository.save(o);
    }

    @Override
    public void delete(Garde_Pharmacie o) {
        gardePharmacieRepository.delete(o);
    }
}
