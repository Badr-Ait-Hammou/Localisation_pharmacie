package com.example.localisation_pharmacie.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;
    private String nom;
    private int longitude;
    private int latitude;
    private String adresse;
    private Byte image;


    @ManyToOne
    private Zone zone;


}
