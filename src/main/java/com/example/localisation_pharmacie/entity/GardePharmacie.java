package com.example.localisation_pharmacie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GardePharmacie {
    @EmbeddedId
    private Garde_PharmacyPk garde_pharmacyEMb;

    @ManyToOne
    @JoinColumn(name = "pharmacie",insertable = false,updatable = false)
    @JsonIgnore
    private Pharmacie pharmacie;

    @ManyToOne
    @JoinColumn(name = "garde",insertable = false,updatable = false)
    @JsonIgnore
    private Garde garde;

    @Temporal(TemporalType.DATE)
    private Date date_fin;


}
