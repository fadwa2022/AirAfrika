package com.example.demo4.dao;

import com.example.demo4.entités.Client;
import com.example.demo4.entités.Reservation;
import com.example.demo4.entités.Vol;

import java.util.List;
import java.util.Optional;
public interface ReservationDAO {
    public Optional<Reservation>addReservation(Reservation reservation);
    public Optional<Reservation>updateClient(Reservation reservation);
    public Optional<Reservation>deleteReservation(int reservationId);
    public  Optional<List<Reservation>> findAllReservation() ;
    public Optional<List<Reservation>> findReservationByClient(Client client);
    public Optional<List<Reservation>> findReservationByvol(Vol vol);

}
