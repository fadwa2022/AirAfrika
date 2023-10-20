package com.example.demo4.entités;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "aeroports")
public class Aeroports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Column(name = "nomdaeroport")
    private String Nomdaeroport;
    @Column(name = "payerdaeroport")
    private String Payerdaeroport;

    public Aeroports() {
    }

    public Aeroports(String nomdaeroport, String payerdaeroport) {
        Nomdaeroport = nomdaeroport;
        Payerdaeroport = payerdaeroport;
    }

    public int getId() {
        return id;
    }


    public String getNomdaeroport() {
        return Nomdaeroport;
    }

    public void setNomdaeroport(String nomdaeroport) {
        Nomdaeroport = nomdaeroport;
    }

    public String getPayerdaeroport() {
        return Payerdaeroport;
    }

    public void setPayerdaeroport(String payerdaeroport) {
        Payerdaeroport = payerdaeroport;
    }
}
