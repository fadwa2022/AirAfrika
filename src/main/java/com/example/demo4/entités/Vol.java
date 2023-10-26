package com.example.demo4.entités;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "vol")
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "villedepart")
    private Aeroports villedepart;

    @OneToOne
    @JoinColumn(name = "villearrivee")
    private Aeroports villearrivee;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateetheurededepart")
    private Date dateetheurededépart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateetheurearrivee")
    private Date dateetheurearrivée;
    @Column(name = "nombredeplacesdisponibles")
    private int nombreDePlacesDisponibles;
    @Column(name = "tarif")

    private float tarif;

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public Vol() {
    }

    public Vol( Aeroports villedepart, Aeroports villearrivee, Date dateetheurededépart, Date dateetheurearrivée, int nombreDePlacesDisponibles,float tarif) {
        this.villedepart = villedepart;
        this.villearrivee = villearrivee;
        this.dateetheurededépart = dateetheurededépart;
        this.dateetheurearrivée = dateetheurearrivée;
        this.nombreDePlacesDisponibles = nombreDePlacesDisponibles;
        this.tarif = tarif;
    }

    public int getId() {
        return id;
    }


    public Aeroports getVilledepart() {
        return villedepart;
    }

    public void setVilledepart(Aeroports villedepart) {
        this.villedepart = villedepart;
    }

    public Aeroports getVillearrivee() {
        return villearrivee;
    }

    public void setVillearrivee(Aeroports villearrivee) {
        this.villearrivee = villearrivee;
    }

    public Date getDateetheurededépart() {
        return dateetheurededépart;
    }

    public void setDateetheurededépart(Date dateetheurededépart) {
        this.dateetheurededépart = dateetheurededépart;
    }

    public Date getDateetheurearrivée() {
        return dateetheurearrivée;
    }

    public void setDateetheurearrivée(Date dateetheurearrivée) {
        this.dateetheurearrivée = dateetheurearrivée;
    }

    public int getNombreDePlacesDisponibles() {
        return nombreDePlacesDisponibles;
    }

    public void setNombreDePlacesDisponibles(int nombreDePlacesDisponibles) {
        this.nombreDePlacesDisponibles = nombreDePlacesDisponibles;
    }
}

