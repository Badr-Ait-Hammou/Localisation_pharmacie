package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.Ville;
import com.example.localisation_pharmacie.entity.Zone;
import com.example.localisation_pharmacie.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired
    private VilleController villeController;



   /* @GetMapping("/byzoneid/{id}")
    public Ville findVilleByzone(int id) {
        return zoneRepository.findVilleByzone(id);
    }
*/



    @GetMapping("/")
    public List<Zone> findAll() {
        return zoneRepository.findAll();
    }

    @PostMapping("/save")
    public int save(@RequestBody Zone zone) {
        Ville ville=villeController.findByID(zone.getId());
        zone.setVille(ville);
        if(ville==null){
            return -1;
        }else{
            zoneRepository.save(zone);
            return 1;
        }

    }

    @GetMapping("/id/{id}")
    public  Zone findById(@PathVariable int id) {
        return zoneRepository.findById(id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable int id ) {
        zoneRepository.deleteById(id);
    }
}
