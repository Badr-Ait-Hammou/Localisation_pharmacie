package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.GardePharmacie;
import com.example.localisation_pharmacie.service.GardPharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gardepharmacies")
@CrossOrigin
public class GardePharmacieController {

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

    @PostMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody GardePharmacie gardePharmacieinfo) {
        gardPharmacieService.update(id, gardePharmacieinfo);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable int id) {
        GardePharmacie gardePharmacie=gardPharmacieService.findById(id);
        gardPharmacieService.delete(gardePharmacie);
    }


}
