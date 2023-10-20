package com.example.demo4.dao;

import com.example.demo4.entités.Administrateur;

import java.util.List;
import java.util.Optional;

public interface AdministrateurDAO {
    // public Optional<Administrateur>addAdministrateur(Administrateur administrateur);
    // public Optional<Administrateur>updateAdministrateur(Administrateur administrateur);
    // public Optional<Administrateur>deleteAdministrateur(int administrateurId);
    // public Optional<List<Administrateur>>findAllAdministrateur();
    public Administrateur findAdministrateur();
}
