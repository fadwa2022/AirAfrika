package com.example.demo4.entités;

import jakarta.persistence.*;

@Entity
@Table(name = "administrateur")
public class Administrateur {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
    @Column(name = "email")

    private String Email;
    @Column(name = "password")

    private String Password;

    public Administrateur() {
    }

    public Administrateur(int id, String email, String password) {
        this.id = id;
        Email = email;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
