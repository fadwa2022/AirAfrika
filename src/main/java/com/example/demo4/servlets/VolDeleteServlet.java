package com.example.demo4.servlets;

import com.example.demo4.services.VolService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "VolsDeleteServlet", value = "/Vols/Delete/*")
public class VolDeleteServlet extends HttpServlet {
    VolService volService = new VolService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            try {
                int matricule = Integer.parseInt(pathInfo.substring(1));
                volService.deleteVol(matricule);
            } catch (NumberFormatException e) {
                // Handle invalid input
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid matricule");
                return;
            }
        } else {
            // Handle missing matricule
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Matricule not provided");
            return;
        }

        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
