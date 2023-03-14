package com.example.localisation_pharmacie.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "zone", fetch = FetchType.EAGER)
    private List<Pharmacie> pharmacieList;

    @ManyToOne
    private Ville ville;
}
