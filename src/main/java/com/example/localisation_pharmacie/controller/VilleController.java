package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.Ville;
import com.example.localisation_pharmacie.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/villes")
public class VilleController {

    @Autowired
    private VilleRepository villeRepository;

    @PostMapping("/save")
    public int save(@RequestBody Ville ville) {
         villeRepository.save(ville);
         return 1;
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable int id) {
        villeRepository.deleteById(id);
    }

    @GetMapping("/")
    public List<Ville> findAll() {
        return villeRepository.findAll();
    }



    @GetMapping("/id/{id}")
    public Ville findById(@PathVariable int id) {
        return villeRepository.findById(id);
    }
}
