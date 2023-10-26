package com.example.demo4.dao;

import com.example.demo4.entités.Client;
import com.example.demo4.entités.Reservation;
import com.example.demo4.entités.Vol;

import java.util.List;
import java.util.Optional;
public interface ReservationDAO {
    public Reservation addReservation(Reservation reservation);
    public Reservation updateClient(Reservation reservation);
    public Reservation deleteReservation(int reservationId);
    public  List<Reservation> findAllReservation() ;
    public List<Reservation> findReservationByClient(Client client);
    public List<Reservation> findReservationByvol(Vol vol);

}
