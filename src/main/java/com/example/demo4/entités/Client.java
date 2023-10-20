package com.example.demo4.entités;

import jakarta.persistence.*;


@Entity
@Table(name = "client")
public class Client {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "telephone")
        private String telephone;
    @Column(name = "email")

    private String email;
        @Column(name = "prenom")
        private String prenom;
    @Column(name = "nom")

    private String nom;
    @Column(name = "password")
    private String password;


    public Client() {
    }

    public Client(int id,String telephone, String email, String prenom, String nom,String password) {
        this.id = id;
        this.telephone = telephone;
        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
        this.password =password;
    }

    public int getId() {
        return id;
    }
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


