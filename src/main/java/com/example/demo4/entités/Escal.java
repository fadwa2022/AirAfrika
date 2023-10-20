package com.example.demo4.entités;

import jakarta.persistence.*;

@Entity
@Table(name = "escal")
public class Escal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;
    @ManyToOne
    @JoinColumn(name = "aeroport_ID")

    private Aeroports aeroport_ID;
    @ManyToOne
    @JoinColumn(name = "vol_ID")
    private Vol vol_ID;

    public Escal() {
    }

    public Escal(int ID, Aeroports aeroport_ID, Vol vol_ID) {
        this.ID = ID;
        aeroport_ID = aeroport_ID;
        vol_ID = vol_ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Aeroports getAeroport_ID() {
        return aeroport_ID;
    }

    public void setAeroport_ID(Aeroports aeroport_ID) {
        aeroport_ID = aeroport_ID;
    }

    public Vol getVol_ID() {
        return vol_ID;
    }

    public void setVol_ID(Vol vol_ID) {
        vol_ID = vol_ID;
    }
}
