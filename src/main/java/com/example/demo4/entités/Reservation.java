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
    @ManyToOne
    @JoinColumn(name = "extras")
        private Extra extras;
        private float montanttotal;


        public Reservation() {
        }

        public Reservation(int id, Client client, Vol vol, Extra extras, int montanttotal) {
        this.id = id;
        this.client = client;
        this.vol = vol;
        this.extras = extras;
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

    public Extra getExtra() {
        return extras;
    }

    public  void setExtra(Extra extras) {
        this.extras = extras;
    }

    public float getMontanttotal() {
        return montanttotal;
    }

    public  void setMontanttotal(float montanttotal) {
        this.montanttotal = montanttotal;
    }
}


