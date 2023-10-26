package com.example.demo4.dao.Impl;

import com.example.demo4.connection.Jpa;
import com.example.demo4.dao.ReservationDAO;
import com.example.demo4.entités.Client;
import com.example.demo4.entités.Reservation;
import com.example.demo4.entités.Vol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    static EntityManager entityManager = Jpa.getInstance().getEntityManager();

    @Override
    public Reservation addReservation(Reservation reservation) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(reservation);
            transaction.commit();
            return reservation;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }    }

    @Override
    public Reservation updateClient(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation deleteReservation(int reservationId) {
        return null;
    }

    @Override
    public List<Reservation> findAllReservation() {
        return null;
    }

    @Override
    public List<Reservation> findReservationByClient(Client client) {
        return null;
    }

    @Override
    public List<Reservation> findReservationByvol(Vol vol) {
        return null;
    }
}
