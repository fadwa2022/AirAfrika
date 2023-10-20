package com.example.demo4.dao.Impl;

import com.example.demo4.connection.Jpa;
import com.example.demo4.dao.VolDAO;
import com.example.demo4.entités.Vol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public class VolDAOImpl implements VolDAO {

    static EntityManager entityManager = Jpa.getInstance().getEntityManager();

    @Override
    public Vol addVol(Vol vol) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(vol);
            transaction.commit();
            return vol;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Vol updateVolClient(Vol vol) {
        return null;
    }

    @Override
    public Vol deleteVol(int volId) {
        return null;
    }

    @Override
    public List<Vol> findAllVols() {
        return entityManager.createQuery("SELECT v FROM Vol v", Vol.class).getResultList();
          }

    @Override
    public Vol findVolById(int volId) {
        return null;
    }
}
