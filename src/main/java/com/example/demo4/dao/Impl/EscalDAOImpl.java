package com.example.demo4.dao.Impl;

import com.example.demo4.connection.Jpa;
import com.example.demo4.dao.EscalDAO;
import com.example.demo4.entités.Escal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class EscalDAOImpl implements EscalDAO {
    static EntityManager entityManager = Jpa.getInstance().getEntityManager();


    @Override
    public Escal addEscal(Escal escal) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(escal);
            transaction.commit();
            return escal;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Escal updateEscal(Escal escal) {
        return null;
    }

    @Override
    public Escal deleteEscal(int escalId) {
        return null;
    }

    @Override
    public List<Escal> findAllEscal() {
        return entityManager.createQuery("SELECT e FROM Escal e", Escal.class).getResultList();

    }

    @Override
    public Escal findEscalById(int escalId) {
        return null;
    }

    @Override
    public List<Escal> findEscalByvol(int volId) {
        return null;
    }
}
