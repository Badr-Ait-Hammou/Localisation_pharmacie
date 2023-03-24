package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.Garde;
import com.example.localisation_pharmacie.repository.GardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GardeService implements IDao<Garde> {


    @Autowired
    private GardeRepository gardeRepository;

    @Override
    public Garde save(Garde o) {
        return gardeRepository.save(o);
    }

    @Override
    public List<Garde> findAll() {
        return gardeRepository.findAll();
    }


    @Override
    public Garde findById(int id) {
        return gardeRepository.findById(id);
    }


    public void update(Integer id,Garde gardeinfo) {
        Garde garde=gardeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("garde not found with id " + id));
        garde.setType(gardeinfo.getType());

        gardeRepository.save(garde);
    }

    @Override
    public void delete(Garde o) {
    gardeRepository.delete(o);
    }
}
