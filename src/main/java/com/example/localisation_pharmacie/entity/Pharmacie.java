package com.example.localisation_pharmacie.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

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


    @ManyToOne(fetch = FetchType.EAGER)
    private Zone zone;

    @OneToMany(mappedBy = "pharmacie")
     private List<Garde_Pharmacie> garde_pharmacieList;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user")
    @JsonIgnore
    private User user;


}
