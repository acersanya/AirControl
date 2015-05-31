/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.techyari.example.controller;

import in.techyari.example.dao.FlightDaoIml;
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
 * @author Александр
 */
@WebServlet("/DeleteFlightController")
public class DeleteFlightController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteFlightController() {
       super();
    }
    
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("delId"));
        FlightDaoIml flightDao = new FlightDaoIml();
        int result = flightDao.removeFlight(id);
        if(result==0){
            response.sendRedirect("fail.html");
        }
        else{
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