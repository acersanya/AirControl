/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.techyari.example.controller;
import in.techyari.example.dao.*;
import in.techyari.example.model.Flight;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
@WebServlet("/modifyFlightController")
public class modifyFlightController extends HttpServlet {
 private static final long serialVersionUID = 1L;

public modifyFlightController(){
    super();
}


   protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Flight flight = new Flight();
       flight.setId(Integer.parseInt(request.getParameter("flightId")));
       flight.setArrivalPlace(request.getParameter("arrival_place"));
       flight.setArrivalTime(request.getParameter("arrival_time"));
       flight.setDeparturePlace(request.getParameter("departure_place"));
       flight.setDepartureTime(request.getParameter("departure_time"));
       FlightDaoIml flyDao = new FlightDaoIml();
       flyDao.updateFlight(flight);
       response.sendRedirect("flightView.jsp");
       
   }


     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
         @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
 
}
