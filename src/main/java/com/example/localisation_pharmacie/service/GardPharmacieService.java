package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.Garde;
import com.example.localisation_pharmacie.entity.GardePharmacie;
import com.example.localisation_pharmacie.entity.Garde_PharmacyPk;
import com.example.localisation_pharmacie.entity.Pharmacie;
import com.example.localisation_pharmacie.repository.GardePharmacieRepository;
import com.example.localisation_pharmacie.repository.GardeRepository;
import com.example.localisation_pharmacie.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class GardPharmacieService implements IDao<GardePharmacie> {




    @Autowired
    private GardePharmacieRepository gardePharmacieRepository;
    private GardeRepository gardeRepository;
    private PharmacieRepository pharmacieRepository;

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
        return null;
    }

/*
    public void update(Integer id,GardePharmacie gardePharmacieinfo) {
        GardePharmacie gardePharmacie=gardePharmacieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("garde pharmacy not found with id " + id));
        gardePharmacie.setGarde(gardePharmacieinfo.getGarde());
        gardePharmacie.setPharmacie(gardePharmacieinfo.getPharmacie());
        gardePharmacie.setDate_fin(gardePharmacieinfo.getDate_fin());
            gardePharmacieRepository.save(gardePharmacie);
    }
*/
    @Override
    public void delete(GardePharmacie o) {
        gardePharmacieRepository.delete(o);
    }

    /*
    public GardePharmacie findgardepahrmacie(int gardeid, int pharmacieid, Date date_fin){
        Garde garde= gardeRepository.findById(gardeid);
        Pharmacie pharmacie=pharmacieRepository.findById(pharmacieid);
        return gardePharmacieRepository.
    }
    */
    public GardePharmacie findByDateDebut(Date datedebut, int idpharmacie, int idgarde){
        return this.findAll().stream().filter(gardePharmacie ->
                        gardePharmacie.getGarde_pharmacyEMb().getDateDebut().equals(datedebut) &&
                                gardePharmacie.getGarde_pharmacyEMb().getPharmacie() == idpharmacie &&
                                gardePharmacie.getGarde_pharmacyEMb().getGarde() == idgarde )
                .findFirst().orElse(null);
    }



    public void deleteByDateDebut(Date datedebut, int idpharmacie, int idgarde) {
        GardePharmacie gardePharmacie = this.findByDateDebut(datedebut, idpharmacie, idgarde);
        if (gardePharmacie != null) {
            this.gardePharmacieRepository.delete(gardePharmacie);
        }
    }
}
