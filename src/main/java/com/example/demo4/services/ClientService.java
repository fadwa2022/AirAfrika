package com.example.demo4.services;

import com.example.demo4.dao.AdministrateurDAO;
import com.example.demo4.dao.ClientDAO;
import com.example.demo4.dao.Impl.AdministrateurDAOImpl;
import com.example.demo4.dao.Impl.ClientDAOImpl;
import com.example.demo4.entités.Client;
import com.example.demo4.standard.ValidationUtils;

public class ClientService {
    private static ClientDAO clientDAOImpl ;
    private ValidationUtils validationUtils;

    public ClientService() {
        this.clientDAOImpl = new ClientDAOImpl();
        this.validationUtils =new ValidationUtils();

    }

    public boolean ajouterClient(String nom, String prenom, String email, String telephone,String password) {
        if (!validationUtils.isValidString(nom) || !validationUtils.isValidString(prenom) ||
                !validationUtils.isValidEmail(email) || !validationUtils.isValidTelephone(telephone)) {
            return false;
        }

        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setEmail(email);
        client.setTelephone(telephone);
        client.setPassword(password);

        Client addedClient = clientDAOImpl.addClient(client);

        return addedClient != null; // Si l'ajout du client a réussi envoyer true
    }
    public  Client SearchClient(String email, String password) {
        Client searchedClient= null;
        searchedClient = clientDAOImpl.findClientByEmail(email, password);

        return searchedClient ; // Si l'ajout du client a réussi envoyer true
    }


}
