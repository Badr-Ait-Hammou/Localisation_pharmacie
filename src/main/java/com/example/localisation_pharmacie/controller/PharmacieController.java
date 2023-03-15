package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.Pharmacie;
import com.example.localisation_pharmacie.entity.Zone;
import com.example.localisation_pharmacie.repository.PharmacieRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacie")
public class PharmacieController {
    @Autowired
    private PharmacieRepository pharmacieRepository;
    @Autowired
    private ZoneController zoneController;
    @PostMapping("/save")
    public int save(@RequestBody Pharmacie pharmacie) {
      Zone zone=zoneController.findById(pharmacie.getId());
      pharmacie.setZone(zone);
        if(zone==null){
            return -1;
        }else{
            pharmacieRepository.save(pharmacie);
            return 1;
        }

    }
    @GetMapping("/id/{id}")
    public Pharmacie findById(@PathVariable int id) {
        return pharmacieRepository.findById(id);
    }

    @GetMapping("/")
    public  List<Pharmacie> findAll() {
        return pharmacieRepository.findAll();
    }

    @GetMapping("/byzone/id/{id}")
    public List<Pharmacie> findByZoneId(@PathVariable int id) {
        return pharmacieRepository.findByZoneId(id);
    }

    @Transactional
    @DeleteMapping("/byzone/id/{id}")
    public int deleteByZoneId(@PathVariable int id) {
        return pharmacieRepository.deleteByZoneId(id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Integer integer) {
        pharmacieRepository.deleteById(integer);
    }
}
