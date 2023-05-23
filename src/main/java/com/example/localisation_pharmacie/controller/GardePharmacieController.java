package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.GardePharmacie;
import com.example.localisation_pharmacie.entity.Garde_PharmacyPk;
import com.example.localisation_pharmacie.service.GardPharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/controller/gardepharmacies")
@CrossOrigin
public class GardePharmacieController {

    @GetMapping("/{datedebut}/idpharmacie/{idpharmacie}/idgarde/{idgarde}")
    public GardePharmacie findByDateDebut(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date datedebut,@PathVariable int idpharmacie,@PathVariable int idgarde) {
        return gardPharmacieService.findByDateDebut(datedebut, idpharmacie, idgarde);
    }

    @DeleteMapping("/{datedebut}/idpharmacie/{idpharmacie}/idgarde/{idgarde}")
    public void deleteByDateDebut(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date datedebut,@PathVariable int idpharmacie,@PathVariable int idgarde) {
        gardPharmacieService.deleteByDateDebut(datedebut, idpharmacie, idgarde);
    }
/*
    @PutMapping("/{datedebut}/idpharmacie/{idpharmacie}/idgarde/{idgarde}")
    public void updategardepharmacie(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date datedebut,@PathVariable int idpharmacie,@PathVariable int idgarde,@RequestBody GardePharmacie gardepharmacieinfo) {
        gardPharmacieService.updategardepharmacie(datedebut, idpharmacie, idgarde, gardepharmacieinfo);
    }
*/

    @PutMapping("/{datedebut}/idpharmacie/{idpharmacie}/idgarde/{idgarde}")
    public GardePharmacie updateg(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date datedebut,@PathVariable int idpharmacie,@PathVariable int idgarde,@RequestBody GardePharmacie gardePharmacieinfo) {
        return gardPharmacieService.updateGardePharmacie(datedebut, idpharmacie, idgarde, gardePharmacieinfo);
    }

    @Autowired
    private GardPharmacieService gardPharmacieService;

    @PostMapping("/save")
    public GardePharmacie save(@RequestBody GardePharmacie gardePharmacie) {
        return gardPharmacieService.save(gardePharmacie);
    }

    @GetMapping("/")
    public List<GardePharmacie> findAll() {
        return gardPharmacieService.findAll();
    }

    @GetMapping("/id/{id}")
    public GardePharmacie findById(@PathVariable int id) {
        return gardPharmacieService.findById(id);
    }
/*
    @PostMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody GardePharmacie gardePharmacieinfo) {
        gardPharmacieService.update(id, gardePharmacieinfo);
    }
*/


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        GardePharmacie gardePharmacie=gardPharmacieService.findById(id);
        gardPharmacieService.delete(gardePharmacie);
    }


}
