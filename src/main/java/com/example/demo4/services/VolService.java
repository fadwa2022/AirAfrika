package com.example.demo4.services;

import com.example.demo4.dao.EscalDAO;
import com.example.demo4.dao.Impl.EscalDAOImpl;
import com.example.demo4.dao.Impl.VolDAOImpl;
import com.example.demo4.dao.VolDAO;
import com.example.demo4.entités.Administrateur;
import com.example.demo4.entités.Aeroports;
import com.example.demo4.entités.Escal;
import com.example.demo4.entités.Vol;

import java.util.Date;
import java.util.List;

public class VolService {
    private VolDAO volDAO;
    private EscalDAO escalDAO;
    AeroportsService aeroportsService =new AeroportsService();

    public VolService() {
        this.volDAO = new VolDAOImpl();
        this.escalDAO = new EscalDAOImpl();
    }
    public List<Vol> findAllVols() {
        if (volDAO != null) {
            return volDAO.findAllVols();
        } else {
            throw new NullPointerException("volDAOImpl is null");
        }
    }
    public Vol addVol(Vol vol, List<Integer> escals,int idvol) {

        if (volDAO != null) {
            Vol v = volDAO.addVol(vol);
            escals.forEach(e->{
                Escal esc = new Escal();
                Aeroports ar = aeroportsService.findAeroportByID(e);
                Vol vl = findVolById(idvol+1);

                System.out.println("vol : " +vl.getId());
                System.out.println("ar : " +ar.getId());

                esc.setVol_ID(vl);
                esc.setAeroport_ID(ar);


                escalDAO.addEscal(esc);
            });
            return v;
        } else {
            throw new NullPointerException("volDAOImpl is null");
        }
    }
    public Vol updateVol(Vol vol) {
        if (volDAO != null) {
            return volDAO.updateVol(vol);
        } else {
            throw new NullPointerException("volDAOImpl is null");
        }
    }
    public void deleteVol(int volId) {
        if (volDAO != null) {
            volDAO.deleteVol(volId);
        } else {
            throw new NullPointerException("volDAOImpl is null");
        }
    }
    public Vol findVolById(int volId) {
        if (volDAO != null) {
            return volDAO.findVolById(volId);
        } else {
            throw new NullPointerException("volDAOImpl is null");
        }
    }
    public List<Vol> searchVol (Aeroports aeroportArrivee, Aeroports aeroportDepart, Date dateArrivee, Date dateDepart){
        if (volDAO != null) {
            return volDAO.searchVol( aeroportArrivee,  aeroportDepart,  dateArrivee, dateDepart);
        } else {
            throw new NullPointerException("volDAOImpl is null");
        }
    }


}
