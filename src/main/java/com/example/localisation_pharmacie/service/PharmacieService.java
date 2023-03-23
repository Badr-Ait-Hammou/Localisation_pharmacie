package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.Pharmacie;
import com.example.localisation_pharmacie.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacieService implements IDao<Pharmacie> {


    @Autowired
    private PharmacieRepository pharmacieRepository;
    public List<Pharmacie> findByZoneId(int id) {
        return pharmacieRepository.findByZoneId(id);
    }

    public List<Pharmacie> findPharmaciyByVilleAndZone(String ville, String zone) {
        return pharmacieRepository.findPharmaciyByVilleAndZone(ville, zone);
    }

    public List<Pharmacie> findPharmacyAvailableZonePer(String ville, String zone, String period) {
        return pharmacieRepository.findPharmacyAvailableZonePer(ville, zone, period);
    }

    public int deleteByZoneId(int id) {
        return pharmacieRepository.deleteByZoneId(id);
    }



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


    public void update(Integer id,Pharmacie pharmacieinfo) {
        Pharmacie pharmacie=pharmacieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("pharmacie not found with id " + id));
        pharmacie.setAdresse(pharmacieinfo.getAdresse());
        pharmacie.setNom(pharmacieinfo.getNom());
        pharmacie.setZone(pharmacieinfo.getZone());
        pharmacie.setLatitude(pharmacieinfo.getLatitude());
        pharmacie.setLongitude(pharmacieinfo.getLongitude());
        pharmacie.setUser(pharmacieinfo.getUser());
        pharmacieRepository.save(pharmacie);
    }

    @Override
    public void delete(Pharmacie o) {
        pharmacieRepository.delete(o);
    }
}
