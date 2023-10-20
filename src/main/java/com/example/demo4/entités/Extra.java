package com.example.demo4.entités;

import jakarta.persistence.*;
@Entity
@Table(name = "extra")
public class Extra {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String nom;
        private float tarif;

    public Extra() {
    }

    public Extra(int id, String nom, float tarif) {
        this.id = id;
        this.nom = nom;
        this.tarif = tarif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }
}

