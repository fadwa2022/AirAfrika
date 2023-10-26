package com.example.demo4.entités;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
