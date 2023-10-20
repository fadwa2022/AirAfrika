package com.example.demo4.servlets;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet(name = "Connection", value = "/Connection")
public class ConnectionServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Cookie emailCookie = new Cookie("email", email);
        Cookie passwordCookie = new Cookie("password", password);
        emailCookie.setMaxAge(3600); // Par exemple, 1 heure
        passwordCookie.setMaxAge(3600);
        response.addCookie(emailCookie);
        response.addCookie(passwordCookie);
        if ("admin".equals(email)) {
            response.sendRedirect("Administrateur");
        } else {
            response.sendRedirect("Clients");
        }
    }

}
