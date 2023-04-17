package com.example.localisation_pharmacie.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;
    private String nom;
    private double longitude;
    private double latitude;
    private String adresse;
    @Column(nullable = true, length = 64)
    private String photos;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("ville")
    private Zone zone;

    @OneToMany(mappedBy = "pharmacie")
    @JsonIgnore
     private List<GardePharmacie> garde_pharmacieList;

   // @OneToOne(fetch=FetchType.EAGER)
   // @JoinColumn(name = "user")
   // @JsonIgnore
    @ManyToOne
    private User user;


}
