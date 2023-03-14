package com.example.localisation_pharmacie.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Garde_Pharmacie {
    @EmbeddedId
    private Garde_PharmacyPk garde_pharmacyEMb;

    @ManyToOne
    @JoinColumn(name = "pharmacie",insertable = false,updatable = false)
    private Pharmacie pharmacie;

    @ManyToOne
    @JoinColumn(name = "garde",insertable = false,updatable = false)
    private Garde garde;

    @Temporal(TemporalType.DATE)
    private Date date_fin;


}
