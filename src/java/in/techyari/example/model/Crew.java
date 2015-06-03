/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.techyari.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Crew implements Serializable{
    private  List<User> crewList = new ArrayList<>();

    public List<User> getCrewList() {
        return crewList;
    }

    public void setCrewList(List<User> crewList) {
        this.crewList = crewList;
    }
    
    public void addToCrew (User u){
        this.crewList.add(u);
    }
    
}
