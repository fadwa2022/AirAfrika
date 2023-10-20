package com.example.demo4.dao;

import com.example.demo4.entités.Vol;
import java.util.List;
import java.util.Optional;
public interface VolDAO {
    public Vol addVol(Vol vol);
    public Vol updateVolClient(Vol vol);
    public Vol deleteVol(int volId);
    public List<Vol> findAllVols() ;
    public Vol findVolById(int volId);
}
