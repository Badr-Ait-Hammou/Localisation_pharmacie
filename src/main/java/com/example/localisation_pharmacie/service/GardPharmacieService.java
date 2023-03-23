package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.GardePharmacie;
import com.example.localisation_pharmacie.repository.GardePharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GardPharmacieService implements IDao<GardePharmacie> {

    @Autowired
    private GardePharmacieRepository gardePharmacieRepository;

    @Override
    public GardePharmacie save(GardePharmacie o) {
        return gardePharmacieRepository.save(o);
    }

    @Override
    public List<GardePharmacie> findAll() {
        return gardePharmacieRepository.findAll();
    }

    @Override
    public GardePharmacie findById(int id) {
        return gardePharmacieRepository.findById(id);
    }


    public void update(GardePharmacie o) {
            gardePharmacieRepository.save(o);
    }

    @Override
    public void delete(GardePharmacie o) {
        gardePharmacieRepository.delete(o);
    }
}
