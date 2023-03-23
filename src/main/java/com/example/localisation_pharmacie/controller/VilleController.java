package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.Ville;
import com.example.localisation_pharmacie.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/villes")
public class VilleController {

    @Autowired
    private VilleService villeService;
    @PostMapping("/save")
    public Ville save(@RequestBody Ville ville) {
        return villeService.save(ville);
    }

    @GetMapping("/")
    public List<Ville> findAll() {
        return villeService.findAll();
    }

    @GetMapping("/id/{id}")
    public Ville findById(@PathVariable int id) {
        return villeService.findById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Ville villeinfo) {
        villeService.update(id, villeinfo);
    }

    @DeleteMapping("/")
    public void delete(@PathVariable Ville ville) {
        villeService.delete(ville);
    }




}
