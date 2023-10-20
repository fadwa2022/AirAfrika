package com.example.demo4.servlets;

import com.example.demo4.entités.Administrateur;
import com.example.demo4.services.AdministrateurService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet(name = "Administrateur", value = "/Administrateur")
public class AdministrateurServlet extends HttpServlet {

    private AdministrateurService administrateurService;

    public AdministrateurServlet() {
        this.administrateurService = new AdministrateurService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String email = null;
        String password = null;
        Administrateur administrator  = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("email".equals(cookie.getName())) {
                    email = cookie.getValue();
                } else if ("password".equals(cookie.getName())) {
                    password = cookie.getValue();
                }
            }
        }

        if (email != null && password != null) {
           administrator = administrateurService.authenticateAdministrator(email, password);
        }


         if (administrator != null) {

             Cookie emailCookie = new Cookie("adminEmail", administrator.getEmail());
             emailCookie.setMaxAge(30 * 60);
             response.addCookie(emailCookie);
          //  HttpSession session = request.getSession(true);
          //  session.setAttribute("adminUser", administrator);
            response.sendRedirect("home");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("Authentication failed.");
        }
    }

}
