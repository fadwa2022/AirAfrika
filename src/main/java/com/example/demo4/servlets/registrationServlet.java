package com.example.demo4.servlets;

import com.example.demo4.services.ClientService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( name = "Register",value = "/Register")

public class registrationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Vous pouvez définir d'autres en-têtes de réponse si nécessaire, par exemple, le type de contenu
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registre.jsp");

        // Transmettez la demande à la page JSP
        dispatcher.forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Récupérer les paramètres de la requête
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String password = request.getParameter("password");

        // Appeler le service pour ajouter le client
        ClientService clientService = new ClientService();
        boolean ajoutReussi = clientService.ajouterClient(nom, prenom, email, telephone,password);

        if (ajoutReussi) {
            out.println("<script>alert('Client ajouté avec succès !');</script>");
            response.sendRedirect(request.getContextPath() + "/home");

        } else {
            out.println("<script>alert('Échec de l ajout du client. Veuillez vérifier les données.');</script>");
            response.sendRedirect(request.getContextPath() + "/Register");
        }
    }

    public void destroy() {
    } }
