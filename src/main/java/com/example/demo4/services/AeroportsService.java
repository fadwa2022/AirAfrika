package com.example.demo4.services;

import com.example.demo4.dao.AeroportsDAO;
import com.example.demo4.dao.Impl.AeroportsDAOImpl;
import com.example.demo4.dao.Impl.VolDAOImpl;
import com.example.demo4.dao.VolDAO;
import com.example.demo4.entités.Aeroports;
import com.example.demo4.entités.Vol;

import java.util.List;

public class AeroportsService {
    private AeroportsDAO aeroportsDAO;

    public AeroportsService() {
        this.aeroportsDAO = new AeroportsDAOImpl();
    }
    public List<Aeroports> findAllAeroports() {
        if (aeroportsDAO != null) {
            return aeroportsDAO.findAllAeroports();
        } else {
            throw new NullPointerException("aeroportsDAOImpl is null");
        }
    }
    public Aeroports findAeroportByID(int aeroportId) {
        if (aeroportsDAO != null) {
            return aeroportsDAO.findAeroportById(aeroportId);
        } else {
            throw new NullPointerException("aeroportsDAOImpl is null");
        }
    }
}
