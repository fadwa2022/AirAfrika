package com.example.demo4.services;

import com.example.demo4.dao.Impl.ListExtrasClientDAOImpl;
import com.example.demo4.dao.Impl.ReservationDAOImpl;
import com.example.demo4.dao.ListExtrasClientDAO;
import com.example.demo4.dao.ReservationDAO;
import com.example.demo4.entités.ListExtrasClient;
import com.example.demo4.entités.Reservation;

public class ReservationService {

    ReservationDAO  reservationDAO;
    public ReservationService() {
        this.reservationDAO = new ReservationDAOImpl();
    }
    public Reservation addReservation (Reservation reservation) {
        if (reservationDAO != null) {
            return reservationDAO.addReservation(reservation);
        } else {
            throw new NullPointerException("reservationDAOImpl is null");
        }
    }
}
