package com.example.demo4.services;

import com.example.demo4.dao.ExtraDAO;
import com.example.demo4.dao.Impl.ExtraDAOImpl;
import com.example.demo4.dao.Impl.VolDAOImpl;
import com.example.demo4.dao.VolDAO;
import com.example.demo4.entités.Extra;
import com.example.demo4.entités.Vol;

import java.util.List;

public class ExtraService {
    private ExtraDAO extraDAO;

    public ExtraService() {
        this.extraDAO = new ExtraDAOImpl();
    }

    public Extra addExtra(Extra extra) {
        if (extraDAO != null) {
            return extraDAO.addExtra(extra);
        } else {
            throw new NullPointerException("extraDAOImpl is null");
        }
    }
    public List<Extra> findAllExtras() {
        if (extraDAO != null) {
            return extraDAO.findAllExtra();
        } else {
            throw new NullPointerException("extraDAOImpl is null");
        }
    }
    public Extra findAllExtrasByid(int extraid) {
        if (extraDAO != null) {
            return extraDAO.findExtraById(extraid);
        } else {
            throw new NullPointerException("extraDAOImpl is null");
        }
    }
}
