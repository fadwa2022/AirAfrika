package com.example.demo4.dao;

import com.example.demo4.entités.Client;
import com.example.demo4.entités.Extra;

import java.util.List;
import java.util.Optional;

public interface ExtraDAO {
    public Extra addExtra(Extra extra);
    public Extra updateExtra(Extra extra);
    public Extra deleteExtra(int extraId);
    public List<Extra> findAllExtra();
    public Extra findExtraById(int extraId);

}
