package com.example.demo4.servlets;

import com.example.demo4.entités.Aeroports;
import com.example.demo4.entités.Vol;
import com.example.demo4.services.AeroportsService;
import com.example.demo4.services.VolService;
import com.example.demo4.standard.ConvertirDate;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.Date;


@WebServlet( name = "UpdateVolsServlet",value = "/Vols/Update")

public class UpdateVolServlet extends HttpServlet {
    VolService volService = new VolService();

    AeroportsService aeroportsService = new AeroportsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int villeDepart = Integer.parseInt(request.getParameter("villedepart"));
        int villeArrivee = Integer.parseInt(request.getParameter("villearrivee"));
        String dateHeureDepartStr = request.getParameter("dateetheurededépart");
        String dateHeureArriveeStr = request.getParameter("dateetheurearrivée");
        int nombreDePlaces = Integer.parseInt(request.getParameter("nombreDePlacesDisponibles"));
        int tarif = Integer.parseInt(request.getParameter("tarif"));


        Date dateHeureDepart = ConvertirDate.convertirEnDate(dateHeureDepartStr);
        Date dateHeureArrivee = ConvertirDate.convertirEnDate(dateHeureArriveeStr);

        Aeroports aeroportDepart = aeroportsService.findAeroportByID(villeDepart);
        Aeroports aeroportArrivee = aeroportsService.findAeroportByID(villeArrivee);

        Vol vol = new Vol(aeroportDepart, aeroportArrivee, dateHeureDepart, dateHeureArrivee, nombreDePlaces,tarif);

        volService.updateVol(vol);

        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}