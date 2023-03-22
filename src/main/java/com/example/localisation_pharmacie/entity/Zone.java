package com.example.localisation_pharmacie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Pharmacie> pharmacieList;
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Ville ville;
}
