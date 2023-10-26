package com.example.demo4.servlets;

import com.example.demo4.entités.*;
import com.example.demo4.services.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( name = "Reservation",value = "/Reservation")

public class ReservationServlet extends HttpServlet {
        ListExtrasClientService listExtrasClientService =new ListExtrasClientService();
        ClientService clientService = new ClientService();
        ExtraService extraService = new ExtraService();
        ReservationService reservationService =new ReservationService();
        VolService volService= new VolService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cookie[] cookies = request.getCookies();
        List<Integer> extra = new ArrayList<>();
        float mantantextras=0;
        float mantanttotale=0;
        String clientIDValue = null;
        int id = Integer.parseInt(request.getParameter("id"));

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("clientID")) {
                    clientIDValue = cookie.getValue();
                    break;
                }
            }
        }
        Client client= clientService.findClientByID(Integer.parseInt(clientIDValue));

        int i = 0;
        while (request.getParameter("extra"+i) != null){
            extra.add(Integer.parseInt(request.getParameter("extra"+i)));
            Extra extra1 = extraService.findAllExtrasByid(extra.get(i));
            System.out.println(extra1.getTarif());
            mantantextras +=  extra1.getTarif();
            System.out.println(mantantextras);
            ListExtrasClient listExtrasClient= new ListExtrasClient(client,extra1);

            listExtrasClientService.addListExtraClient(listExtrasClient);
            i++;
        }
       Vol vol = volService.findVolById(id);
         mantanttotale = vol.getTarif()+mantantextras;
        Reservation reservation = new Reservation(client,vol,mantanttotale);
        reservationService.addReservation(reservation);

    }
}
