package com.example.demo4.servlets;

import com.example.demo4.entités.Aeroports;
import com.example.demo4.entités.Escal;
import com.example.demo4.entités.Vol;
import com.example.demo4.services.AeroportsService;
import com.example.demo4.services.EscalService;
import com.example.demo4.services.VolService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo4.standard.ConvertirDate.convertirEnDate;
@WebServlet( name = "Search",value = "/Search")
public class SearchVolServlet extends HttpServlet {
    AeroportsService aeroportsService =new AeroportsService();
    VolService volService =new VolService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        int earoportDepart = Integer.parseInt(request.getParameter("aeroportdepart"));
        int earoportArrivee = Integer.parseInt(request.getParameter("aeroportdarrivee"));
        String dateHeureDepartStr = request.getParameter("DateDepart");
        String dateHeureArriveeStr = request.getParameter("DateArrivee");


        Date dateHeureDepart = convertirEnDate(dateHeureDepartStr);
        Date dateHeureArrivee = convertirEnDate(dateHeureArriveeStr);

        System.out.println(dateHeureDepart);
        System.out.println(dateHeureArrivee);
        System.out.println(earoportArrivee);
        System.out.println(earoportDepart);

        Aeroports aeroportDepart = aeroportsService.findAeroportByID(earoportDepart);
        Aeroports aeroportArrivee = aeroportsService.findAeroportByID(earoportArrivee);

        // Créez un objet Vol avec les données

       List <Vol> vols = volService.searchVol(aeroportArrivee,aeroportDepart,dateHeureArrivee,dateHeureDepart);


        for (Vol vol : vols) {
            System.out.println(vol.getId());
        }
        request.setAttribute("vols", vols);

        response.sendRedirect(request.getContextPath() + "/home");    }


}
