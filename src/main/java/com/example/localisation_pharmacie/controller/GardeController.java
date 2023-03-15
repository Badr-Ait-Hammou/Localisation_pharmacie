package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.Garde;
import com.example.localisation_pharmacie.repository.GardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/garde")
public class GardeController {
    @Autowired
    private GardeRepository gardeRepository;

    @GetMapping("/id/{id}")
    public Garde findById(@PathVariable int id) {
        return gardeRepository.findById(id);
    }

    @GetMapping("/")
    public List<Garde> findAll() {
        return gardeRepository.findAll();
    }

    @PostMapping("/save")
    public int save(@RequestBody Garde garde) {
        gardeRepository.save(garde);
        return 1;
    }



    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable int id) {
        gardeRepository.deleteById(id);
    }
}
