package com.example.demo4.dao;

import com.example.demo4.entités.Client;
import com.example.demo4.entités.Escal;

import java.util.List;
import java.util.Optional;

public interface EscalDAO {
    public Optional<Escal> addEscal(Escal escal);
    public Optional<Escal>updateEscal(Escal escal);
    public Optional<Escal>deleteEscal(int escalId);
    public Optional<List<Escal>>findAllEscal();
    public Optional<Escal>findEscalById(int escalId);
    public Optional<List<Escal>>findEscalByvol(int volId);

}
