package com.example.demo4.dao.Impl;

import com.example.demo4.connection.Jpa;
import com.example.demo4.dao.ListExtrasClientDAO;
import com.example.demo4.entités.ListExtrasClient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ListExtrasClientDAOImpl implements ListExtrasClientDAO {
    static EntityManager entityManager = Jpa.getInstance().getEntityManager();

    @Override
    public ListExtrasClient addListExtrasClient(ListExtrasClient listExtrasClient) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(listExtrasClient);
            transaction.commit();
            return listExtrasClient ;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }    }
}
