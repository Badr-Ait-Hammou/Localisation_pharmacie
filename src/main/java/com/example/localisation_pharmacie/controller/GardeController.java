package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.Garde;
import com.example.localisation_pharmacie.repository.GardeRepository;
import com.example.localisation_pharmacie.service.GardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/gardes")
public class GardeController {
    @Autowired
    private GardeService gardeService;
}
