/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.techyari.example.dao;

import in.techyari.example.model.Flight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Александр
 */
public class FlightDaoIml implements FlightDao {

    Database db = new Database();

  
    @Override
    public Flight getFlightById(int id) {
        Statement stm  = null;
        Connection con = null;
        Flight flight = new Flight();
        try {
            con = db.getConnection();
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM flights WHERE flight_id=" + id);
            while (rs.next()) {
                flight.setId(id);
                flight.setArrivalPlace(rs.getString(3));
                flight.setDeparturePlace(rs.getString(2));
                flight.setDepartureTime(rs.getString(5));
                flight.setArrivalTime(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flight;
    }

    
    
    
    
    @Override
    public int createFlight(Flight f) {
        int result = 0;
        try {
            Connection connection = db.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO flights (departure_place,arrival_place,arrival_time,departure_time) VALUES (?,?,?,?)");
            ps.setString(1, f.getDeparturePlace());
            ps.setString(2, f.getArrivalPlace());
            ps.setString(3, f.getArrivalTime());
            ps.setString(4, f.getDepartureTime());
//            ResultSet rs = null;
//            Statement stmt = null;
//            String strQuery = "select * from flights where departure_place='" + f.getDeparturePlace() + "' AND arrival_place='" + f.getArrivalPlace() + "' ";
//            stmt = connection.createStatement();
//            rs = stmt.executeQuery(strQuery);
//            if (rs.next()) {
//                return 0;
//            } else {
//                result = ps.executeUpdate();
//            }
            
            result = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    
    @Override
    public int removeFlight(int id) {
        int result = 0;
        try {
            Connection connection = db.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM flights  WHERE flight_id ='" + id + "'");
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Flight> getFlight() throws IllegalAccessException {
        List<Flight> list = new ArrayList();
        Connection con = null;
        Statement st = null;

        try {
            con = db.getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT *FROM flights ORDER BY flight_id");
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setId(rs.getInt(1));
                flight.setArrivalPlace(rs.getString(3));
                flight.setDeparturePlace(rs.getString(2));
                flight.setDepartureTime(rs.getString(5));
                flight.setArrivalTime(rs.getString(4));
                list.add(flight);
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException e) {
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void updateFlight(Flight f) {
      Connection con = null;
      PreparedStatement ps = null;
     try{
       con =db.getConnection();
       ps = con.prepareStatement("UPDATE flights SET departure_place=? , arrival_place=?, arrival_time=?,departure_time=? WHERE flight_id=?");
            ps.setString(1, f.getDeparturePlace());
            ps.setString(2, f.getArrivalPlace());
            ps.setString(3, f.getArrivalTime());
            ps.setString(4, f.getDepartureTime());
            ps.setInt(5, f.getId());
       ps.executeUpdate();
     }
     catch(SQLException|ClassNotFoundException|InstantiationException|IllegalAccessException e){
         e.printStackTrace();
     }
     finally{
         try{
             if(ps!=null){
                 ps.close();
             }
             if(con!=null){
                 con.close();
             }
         }
         catch(SQLException e){
             e.printStackTrace();
         }
     }
    }

}
