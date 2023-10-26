package com.example.demo4.dao.Impl;

import com.example.demo4.connection.Jpa;
import com.example.demo4.dao.ExtraDAO;
import com.example.demo4.entités.Escal;
import com.example.demo4.entités.Extra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ExtraDAOImpl implements ExtraDAO {
    static EntityManager entityManager = Jpa.getInstance().getEntityManager();

    @Override
    public Extra addExtra(Extra extra) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(extra);
            transaction.commit();
            return extra;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Extra updateExtra(Extra extra) {
        return null;
    }

    @Override
    public Extra deleteExtra(int extraId) {
        return null;
    }

    @Override
    public List<Extra> findAllExtra() {
        return entityManager.createQuery("SELECT e FROM Extra e", Extra.class).getResultList();

    }

    @Override
    public Extra findExtraById(int extraId) {
        return entityManager.find(Extra.class, extraId);
    }
}
