
<%@page import="in.techyari.example.dao.FlightDaoIml" %>
<%@page import="in.techyari.example.model.Flight" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link href="styleOther.css" rel="stylesheet" type="text/css"/>
        <title>Flight update page</title>
    </head>
    <body>
<%@include file="header.jsp"%>
        
        <%
            int id = Integer.parseInt(request.getParameter("updateId"));
            FlightDaoIml fD = new FlightDaoIml();
            Flight flight = fD.getFlightById(id);
        %>
    
         <div id="mystyle" class="myform">
            <form id="form" name="form" action="modifyFlightController" method="post">
                <h1>Update Flight ID:<%=flight.getId()%></h1>
                <p>Modify the following information to update flight ID:<%=flight.getId()%></p>
                <label><input type="hidden" name="flightId" id="flightId" value="<%=flight.getId()%>"/><span class="small"></span></label>                    
                <label>Departure Place<span class="small">Enter departure place</span></label>
                <input type="text" name="departure_place" id="departure_place" value="<%=flight.getDeparturePlace()%>"/>
                <label>Arrival place<span class="small">Enter arrival place</span></label>
                <input type="text" name="arrival_place" id="arrival_place" value="<%=flight.getArrivalPlace()%>"/>
                <label>Departure Time<span class="small">Enter departure time</span></label>
                <input type="text" name="departure_time" id="departure_time" value="<%=flight.getDepartureTime()%>"/>
                <label>Arrival Time<span class="small">Enter arrival time</span></label>
                <input type="text" name="arrival_time" id="arrival_time" value="<%=flight.getArrivalTime()%>"/>
                             
                <button type="submit">Update Flight</button>
                <div class="spacer"></div>
            </form>
        </div>   
         <%@include file="bottom.jsp" %>
           
        
        
    </body>
</html>