/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.techyari.example.model;

/**
 *
 * @author Александр
 */
public class Flight {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private String departurePlace;
    private String arrivalPlace;
    private String departureTime;
    private String arrivalTime;


    public String getDeparturePlace() {
        return departurePlace;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }


    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Flight( String departurePlace, String arrivalPlace, String departureTime, String arrivalTime) {
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight() {
    }

    
    
    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", departurePlace=" + departurePlace + ", arrivalPlace=" + arrivalPlace + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + '}';
    }
    
    
}
