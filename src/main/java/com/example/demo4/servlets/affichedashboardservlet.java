package com.example.demo4.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
public class affichedashboardservlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Vous pouvez définir d'autres en-têtes de réponse si nécessaire, par exemple, le type de contenu
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/dashboard.jsp");

        // Transmettez la demande à la page JSP
        dispatcher.forward(request, response);

    }

    public void destroy() {
    }
}
