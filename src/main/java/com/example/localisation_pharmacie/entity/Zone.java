package com.example.localisation_pharmacie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@Entity
@Getter
@Setter
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
    //@JsonIgnore
    private Ville ville;
}
