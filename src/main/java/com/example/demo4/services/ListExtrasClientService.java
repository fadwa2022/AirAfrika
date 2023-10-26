package com.example.demo4.services;

import com.example.demo4.dao.Impl.ListExtrasClientDAOImpl;
import com.example.demo4.dao.ListExtrasClientDAO;
import com.example.demo4.entités.Extra;
import com.example.demo4.entités.ListExtrasClient;

public class ListExtrasClientService {
    ListExtrasClientDAO listExtrasClientDAO;
    public ListExtrasClientService() {
        this.listExtrasClientDAO = new ListExtrasClientDAOImpl();
    }
    public ListExtrasClient addListExtraClient(ListExtrasClient listExtrasClient) {
        if (listExtrasClientDAO != null) {
            return listExtrasClientDAO.addListExtrasClient(listExtrasClient);
        } else {
            throw new NullPointerException("listExtrasClientDAOImpl is null");
        }
    }
}
