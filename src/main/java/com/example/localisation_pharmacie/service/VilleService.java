package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.Ville;
import com.example.localisation_pharmacie.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
    public void delete(Ville o) {

    }


    public void deleteVille(Integer id) {
        Ville ville = villeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ville not found with id " + id));
        villeRepository.delete(ville);
    }


    public void update(Integer id,Ville villeinfo) {
        Ville ville=villeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ville not found with id " + id));
        ville.setNom(villeinfo.getNom());
        ville.setZoneList(villeinfo.getZoneList());
        villeRepository.save(ville);
    }


}
