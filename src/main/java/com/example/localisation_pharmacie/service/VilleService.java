package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.Ville;
import com.example.localisation_pharmacie.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService implements IDao<Ville> {

    @Autowired
    private VilleRepository villeRepository;

    @Override
    public Ville save(Ville o) {
        return villeRepository.save(o);
    }

    @Override
    public List<Ville> findAll() {
        return villeRepository.findAll();
    }


    @Override
    public Ville findById(int id) {
        return villeRepository.findById(id);
    }

    @Override
    public void update(Ville o) {
        villeRepository.save(o);
    }

    @Override
    public void delete(Ville o) {
        villeRepository.delete(o);
    }
}
