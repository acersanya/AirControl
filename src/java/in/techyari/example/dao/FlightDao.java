/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.techyari.example.dao;

import in.techyari.example.model.Flight;

/**
 *
 * @author Александр
 */
public interface FlightDao {
     public Flight getFlightById(int id);
    public int createFlight(Flight f);
    public int removeFlight(int id);
    public void updateFlight(Flight flight);
}
