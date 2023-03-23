package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.Zone;
import com.example.localisation_pharmacie.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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




    public void update(Integer id,Zone zoneinfo) {
        Zone zone=zoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zone not found with id " + id));
        zone.setNom(zoneinfo.getNom());
        zone.setVille(zoneinfo.getVille());
    zoneRepository.save(zone);
    }

    @Override
    public void delete(Zone o) {
    zoneRepository.delete(o);
    }



    public List<Zone> findAllZones(String nom){
        return zoneRepository.findZoneByVille(nom);
    }
}
