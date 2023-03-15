package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.Ville;
import com.example.localisation_pharmacie.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ville")
public class VilleController {
    @Autowired
    private VilleRepository villeRepository;

    @GetMapping("/id/{id}")
    public Ville findByID(@PathVariable int id) {
        return villeRepository.findById(id);
    }
}
