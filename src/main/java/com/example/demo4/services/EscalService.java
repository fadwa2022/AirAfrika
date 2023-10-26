package com.example.demo4.services;

import com.example.demo4.dao.EscalDAO;
import com.example.demo4.dao.ExtraDAO;
import com.example.demo4.dao.Impl.EscalDAOImpl;
import com.example.demo4.dao.Impl.ExtraDAOImpl;
import com.example.demo4.entités.Escal;
import com.example.demo4.entités.Extra;
import com.example.demo4.entités.Vol;

import java.util.List;

public class EscalService {
    private EscalDAO escalDAO;

    public EscalService() {
        this.escalDAO = new EscalDAOImpl();
    }

    public Escal addEscal(Escal escal) {
        if (escalDAO != null) {
            return escalDAO.addEscal(escal);
        } else {
            throw new NullPointerException("escalDAOImpl is null");
        }
    }
    public List<Escal> findAllEscals() {
        if (escalDAO != null) {
            return escalDAO.findAllEscal();
        } else {
            throw new NullPointerException("escalDAOImpl is null");
        }
    }
}
