package com.example.demo4.services;

import com.example.demo4.dao.AdministrateurDAO;
import com.example.demo4.dao.Impl.AdministrateurDAOImpl;
import com.example.demo4.entités.Administrateur;

public class AdministrateurService {

    private AdministrateurDAO administrateurDAOImpl  ;


    public AdministrateurService() {
        this.administrateurDAOImpl = new AdministrateurDAOImpl();

    }

    public Administrateur getAdministrateur() {
        if (administrateurDAOImpl != null) {
            return administrateurDAOImpl.findAdministrateur();
        } else {
            throw new NullPointerException("administrateurDAOImpl is null");
        }
    }
    public Administrateur authenticateAdministrator(String email, String password) {
        Administrateur administrator = administrateurDAOImpl.findAdministrateur();
        if (administrator != null && administrator.getPassword().equals(password) && administrator.getEmail().equals(email)) {
            return administrator;
        }
        return null;
    }


}
