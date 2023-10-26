package com.example.demo4.entités;

import jakarta.persistence.*;

@Entity
@Table(name = "ListExtrasClient")
public class ListExtrasClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "client")
    private Client idClient;
    @ManyToOne
    @JoinColumn(name = "extra")
    private Extra idExtra;

    public ListExtrasClient(Client idClient, Extra idExtra) {
        this.idClient = idClient;
        this.idExtra = idExtra;
    }

    public ListExtrasClient() {

    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Extra getIdExta() {
        return idExtra;
    }

    public void setIdExta(Extra idExtra) {
        this.idExtra = idExtra;
    }

    public int getId() {
        return id;
    }
}
