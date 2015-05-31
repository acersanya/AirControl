/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.techyari.example.controller;

import in.techyari.example.model.Flight;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.techyari.example.dao.FlightDaoIml;

/**
 *
 * @author Александр
 */
@WebServlet("/AddNewFlight")
public class AddNewFlight extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddNewFlight() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String arrivalPlace = (request.getParameter("arrival_place"));
        String arrivalTime = (request.getParameter("arrival_time"));
        String departutrPlace = (request.getParameter("departure_place"));
        String departuteTime = (request.getParameter("departure_time"));
        FlightDaoIml flightDao = new FlightDaoIml();
        Flight f = new Flight(departutrPlace, arrivalPlace, departuteTime, arrivalTime);
        int result = flightDao.createFlight(f);
        if (result == 0) {
            response.sendRedirect("fail.html");
        } else {
            response.sendRedirect("flightView.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
}
