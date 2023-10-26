package com.example.demo4.servlets;

import com.example.demo4.entités.Aeroports;
import com.example.demo4.entités.Escal;
import com.example.demo4.entités.Vol;
import com.example.demo4.services.AeroportsService;
import com.example.demo4.services.EscalService;
import com.example.demo4.services.VolService;
import com.example.demo4.standard.ConvertirDate;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo4.standard.ConvertirDate.convertirEnDate;


@WebServlet( name = "Vols",value = "/Vols")

public class VolServlet extends HttpServlet {
    VolService volService = new VolService();
    AeroportsService aeroportsService =new AeroportsService();
    EscalService escalService = new EscalService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        int villeDepart = Integer.parseInt(request.getParameter("villedepart"));
        int villeArrivee = Integer.parseInt(request.getParameter("villearrivee"));
        String dateHeureDepartStr = request.getParameter("dateetheurededepart");
        String dateHeureArriveeStr = request.getParameter("dateetheurearrivee");
        int tarif = Integer.parseInt( request.getParameter("tarif"));
        int dernierId = Integer.parseInt(request.getParameter("dernierId"));
        int nombreDePlaces = Integer.parseInt(request.getParameter("nombreDePlacesDisponibles"));


        Date dateHeureDepart = convertirEnDate(dateHeureDepartStr);
        Date dateHeureArrivee = convertirEnDate(dateHeureArriveeStr);

        Aeroports aeroportDepart = aeroportsService.findAeroportByID(villeDepart);
        Aeroports aeroportArrivee = aeroportsService.findAeroportByID(villeArrivee);

        // Créez un objet Vol avec les données
        Vol vol = new Vol(aeroportDepart, aeroportArrivee, dateHeureDepart, dateHeureArrivee, nombreDePlaces,tarif);



        List<Integer> escal = new ArrayList<>();

        int i = 1;
        while (request.getParameter("escale"+i) != null){
            escal.add(Integer.parseInt(request.getParameter("escale"+i)));
            i++;
        }

        volService.addVol(vol,escal,dernierId);



        response.sendRedirect(request.getContextPath() + "/dashboard");
    }


}
