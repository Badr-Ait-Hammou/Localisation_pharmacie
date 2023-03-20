package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.Pharmacie;
import com.example.localisation_pharmacie.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacieService implements IDao<Pharmacie> {

    @Autowired
    private PharmacieRepository pharmacieRepository;

    @Override
    public Pharmacie save(Pharmacie o) {
        return pharmacieRepository.save(o);
    }

    @Override
    public List<Pharmacie> findAll() {
        return pharmacieRepository.findAll();
    }

    @Override
    public Pharmacie findById(int id) {
        return pharmacieRepository.findById(id);
    }

    @Override
    public void update(Pharmacie o) {
        pharmacieRepository.save(o);
    }

    @Override
    public void delete(Pharmacie o) {
        pharmacieRepository.delete(o);
    }
}
