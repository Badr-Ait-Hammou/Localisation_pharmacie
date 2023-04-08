package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.Zone;
import com.example.localisation_pharmacie.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/zones")
@CrossOrigin
public class ZoneController {

    @GetMapping("/")
    public List<Zone> findAll() {
        return zoneService.findAll();
    }

    @Autowired
    private ZoneService zoneService;
    @PutMapping("/id/{id}")
    public void update(@PathVariable Integer id,@RequestBody Zone zoneinfo) {
        zoneService.update(id, zoneinfo);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable int id) {
        Zone zone=zoneService.findById(id);
        zoneService.delete(zone);
    }

    @GetMapping("/ville/{nom}")
    public List<Zone> findAllZonesVille(@PathVariable String nom) {
        return zoneService.findAllZones(nom);
    }



    @PostMapping("/save")
    public Zone save(@RequestBody Zone o) {
        return zoneService.save(o);
    }



    @GetMapping("/id/{id}")
    public Zone findById(@PathVariable int id) {
        return zoneService.findById(id);
    }





}
