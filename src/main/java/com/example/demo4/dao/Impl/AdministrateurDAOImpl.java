package com.example.demo4.dao.Impl;

import com.example.demo4.connection.Jpa;
import com.example.demo4.dao.AdministrateurDAO;
import com.example.demo4.entités.Administrateur;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class AdministrateurDAOImpl implements AdministrateurDAO {



    public  Administrateur findAdministrateur() {
        EntityManager entityManager = Jpa.getInstance().getEntityManager();
        Administrateur administrateur=null;
        try {
            administrateur = entityManager.find(Administrateur.class, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return administrateur;
    }


}
