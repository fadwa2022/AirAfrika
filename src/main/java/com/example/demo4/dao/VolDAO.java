package com.example.demo4.dao;

import com.example.demo4.entités.Aeroports;
import com.example.demo4.entités.Vol;

import java.util.Date;
import java.util.List;
import java.util.Optional;
public interface VolDAO {
    public Vol addVol(Vol vol);
    public Vol updateVol(Vol vol);
    public void deleteVol(int volId);
    public List<Vol> findAllVols() ;
    public Vol findVolById(int volId);
    public List<Vol> searchVol(Aeroports aeroportArrivee, Aeroports aeroportDepart, Date dateArrivee, Date dateDepart) ;
}
