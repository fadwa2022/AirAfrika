package com.example.demo4.dao;

import com.example.demo4.entités.Aeroports;
import com.example.demo4.entités.Client;

import java.util.List;
import java.util.Optional;

public interface ClientDAO {
    public Client addClient(Client client);
    public Client updateClient(Client client);
    public Client deleteClient(int clientId);
    public  List<Client> findAllClient() ;
    public Client findClientByID(int clientId);
    public Client findClientByEmail(String clientEmail,String password);
}
