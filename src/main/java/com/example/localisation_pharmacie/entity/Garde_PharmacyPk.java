package com.example.localisation_pharmacie.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data @NoArgsConstructor
public class Garde_PharmacyEMb implements Serializable {
private int id_Garde;
private int id_Pharmacie;


}
