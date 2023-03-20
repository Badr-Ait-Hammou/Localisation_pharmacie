package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.Zone;
import com.example.localisation_pharmacie.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService implements IDao<Zone> {

    @Autowired
    private ZoneRepository zoneRepository;


    @Override
    public Zone save(Zone o) {
        return zoneRepository.save(o);
    }

    @Override
    public List<Zone> findAll() {
        return zoneRepository.findAll();
    }


    @Override
    public Zone findById(int id) {
        return zoneRepository.findById(id);
    }

    @Override
    public void update(Zone o) {
    zoneRepository.save(o);
    }

    @Override
    public void delete(Zone o) {
    zoneRepository.delete(o);
    }
}
