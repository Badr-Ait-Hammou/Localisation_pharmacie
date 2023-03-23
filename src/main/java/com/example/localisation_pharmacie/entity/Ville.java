package com.example.localisation_pharmacie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;


    @OneToMany(mappedBy = "ville", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Zone> zoneList;

}
