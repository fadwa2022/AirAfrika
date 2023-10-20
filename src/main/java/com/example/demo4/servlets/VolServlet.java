package com.example.demo4.servlets;

import com.example.demo4.entités.Aeroports;
import com.example.demo4.entités.Vol;
import com.example.demo4.services.AeroportsService;
import com.example.demo4.services.VolService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;


@WebServlet( name = "Vols",value = "/Vols")

public class VolServlet extends HttpServlet {
    VolService volService = new VolService();

    AeroportsService aeroportsService =new AeroportsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int villeDepart = Integer.parseInt(request.getParameter("villedepart"));
        int villeArrivee = Integer.parseInt(request.getParameter("villearrivee"));
        String dateHeureDepartStr = request.getParameter("dateetheurededépart");
        String dateHeureArriveeStr = request.getParameter("dateetheurearrivée");
        int nombreDePlaces = Integer.parseInt(request.getParameter("nombreDePlacesDisponibles"));


        Date dateHeureDepart = convertirEnDate(dateHeureDepartStr);
        Date dateHeureArrivee = convertirEnDate(dateHeureArriveeStr);

        Aeroports aeroportDepart = aeroportsService.findAeroportByID(villeDepart);
        Aeroports aeroportArrivee = aeroportsService.findAeroportByID(villeArrivee);

        // Créez un objet Vol avec les données
        Vol vol = new Vol(aeroportDepart, aeroportArrivee, dateHeureDepart, dateHeureArrivee, nombreDePlaces);

        // Enregistrez le vol en utilisant un service approprié
        volService.addVol(vol);

        // Redirigez l'utilisateur vers une page de confirmation ou une autre page de votre choix
        response.sendRedirect("/confirmation.jsp");
    }

    private Date convertirEnDate(String dateStr) {

         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
       try {
       return dateFormat.parse(dateStr);
       } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
