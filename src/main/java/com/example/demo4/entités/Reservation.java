package com.example.demo4.entités;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
    @ManyToOne
    @JoinColumn(name = "client")
        private Client client;
    @ManyToOne
    @JoinColumn(name = "vol")
        private Vol vol;

        private float montanttotal;


        public Reservation() {
        }

        public Reservation( Client client, Vol vol, float montanttotal) {
        this.client = client;
        this.vol = vol;
        this.montanttotal = montanttotal;
        }

    public int getId() {
            return id;
        }

    public void setId(int id) {
            this.id = id;
        }

    public Client getClient() {
        return client;
    }

    public  void setClient(Client client) {
        this.client = client;
    }

    public Vol getVol() {
        return vol;
    }

    public  void setVol(Vol vol) {
        this.vol = vol;
    }



    public float getMontanttotal() {
        return montanttotal;
    }

    public  void setMontanttotal(float montanttotal) {
        this.montanttotal = montanttotal;
    }
}


