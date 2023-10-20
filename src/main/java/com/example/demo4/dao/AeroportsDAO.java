package com.example.demo4.dao;

import com.example.demo4.entités.Aeroports;
import java.util.List;
import java.util.Optional;

public interface AeroportsDAO {
    public Aeroports addAeroports(Aeroports aeroports);
    public Aeroports updateAeroports(Aeroports aeroports);
    public Aeroports deleteAeroports(int aeroportsId);

    public  List<Aeroports> findAllAeroports() ;
    public Aeroports findAeroportById(int aeroportId);
}
