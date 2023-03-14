package com.example.localisation_pharmacie.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data @NoArgsConstructor
public class Garde_PharmacyPk implements Serializable {
private int pharmacie;
private int garde;
private Date datedebut;



}
