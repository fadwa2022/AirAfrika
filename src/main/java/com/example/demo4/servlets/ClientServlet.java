package com.example.demo4.servlets;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;

import com.example.demo4.entités.Client;
import com.example.demo4.services.ClientService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Clients")
public class ClientServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
   ClientService clientService = new ClientService();
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       Cookie[] cookies = request.getCookies();
       String email = null;
       String password = null;
       Client client = null;

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
        client = clientService.SearchClient(email,password);
       }
       if (client != null) {
           Cookie clientEmail = new Cookie("clientEmail", client.getEmail());
           clientEmail.setMaxAge(30 * 60);
           response.addCookie(clientEmail);

           response.sendRedirect("home");
   } else {
           response.setContentType("text/html");
           response.getWriter().println("Authentication failed.");
       }
   }

}

