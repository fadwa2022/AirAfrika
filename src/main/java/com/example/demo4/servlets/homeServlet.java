package com.example.demo4.servlets;

import com.example.demo4.entités.Aeroports;
import com.example.demo4.entités.Escal;
import com.example.demo4.entités.Extra;
import com.example.demo4.entités.Vol;
import com.example.demo4.services.AeroportsService;
import com.example.demo4.services.EscalService;
import com.example.demo4.services.ExtraService;
import com.example.demo4.services.VolService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet( name = "home",value = "/home")

public class homeServlet extends HttpServlet {
    VolService volService =new VolService();
    AeroportsService aeroportsService = new AeroportsService();
    EscalService escalService = new EscalService();
    ExtraService extraService =new ExtraService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Vol> vols = volService.findAllVols();
        List<Aeroports> aeroports =aeroportsService.findAllAeroports();
        List<Escal> escals = escalService.findAllEscals();
        List<Extra> extras = extraService.findAllExtras();
        if (request.getAttribute("vols") != null) {

            vols = (List<Vol>) request.getAttribute("vols");
        }
        request.setAttribute("vols", vols);
        request.setAttribute("aeroports", aeroports);
        request.setAttribute("escals", escals);
        request.setAttribute("extras", extras);

        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");

            // Transmettez la demande à la page JSP
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }


}
