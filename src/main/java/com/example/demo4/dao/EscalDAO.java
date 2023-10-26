package com.example.demo4.dao;

import com.example.demo4.entités.Client;
import com.example.demo4.entités.Escal;

import java.util.List;
import java.util.Optional;

public interface EscalDAO {
    public Escal addEscal(Escal escal);
    public Escal updateEscal(Escal escal);
    public Escal deleteEscal(int escalId);
    public List<Escal> findAllEscal();
    public Escal findEscalById(int escalId);
    public List<Escal> findEscalByvol(int volId);

}
