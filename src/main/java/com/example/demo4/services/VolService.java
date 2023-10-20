package com.example.demo4.services;

import com.example.demo4.dao.Impl.VolDAOImpl;
import com.example.demo4.dao.VolDAO;
import com.example.demo4.entités.Administrateur;
import com.example.demo4.entités.Vol;

import java.util.List;

public class VolService {
    private VolDAO volDAO;

    public VolService() {
        this.volDAO = new VolDAOImpl();
    }
    public List<Vol> findAllVols() {
        if (volDAO != null) {
            return volDAO.findAllVols();
        } else {
            throw new NullPointerException("volDAOImpl is null");
        }
    }
    public Vol addVol(Vol vol) {
        if (volDAO != null) {
            return volDAO.addVol(vol);
        } else {
            throw new NullPointerException("volDAOImpl is null");
        }
    }

}
