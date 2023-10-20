package com.example.demo4.dao;

import com.example.demo4.entités.Client;
import com.example.demo4.entités.Extra;

import java.util.List;
import java.util.Optional;

public interface ExtraDAO {
    public Optional<Extra>addExtra(Extra extra);
    public Optional<Extra>updateExtra(Extra extra);
    public Optional<Extra>deleteExtra(int extraId);
    public  Optional<List<Extra>> findAllExtra();
    public Optional<Extra> findExtraById(int extraId);

}
