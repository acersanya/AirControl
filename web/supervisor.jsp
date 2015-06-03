<%@page import="in.techyari.example.dao.FlightDaoIml" %>
<%@page import="in.techyari.example.model.Flight" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styleOther.css" rel="stylesheet" type="text/css"/>
        <title>Supervisor control page</title>
    </head>
    <body>
        <div>
 <h2 style="color: captiontext;text-align: center;margin-top: 80px;margin-bottom: 10px; border:none;margin-top:0px;">
               Flights
                </h2>
            <table align="center" style="margin-top: 40px">
                <thead>
                    <tr>
                        <th>Flight ID</th>
                        <th>Arrival Place</th>
                        <th>Departute Place</th>
                        <th>DepartureTime</th>
                        <th>ArrivalTime</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        FlightDaoIml fDao = new FlightDaoIml();
                        List<Flight> list = fDao.getFlight();
                        for (Flight e : list) {
                    %>

                    <tr>
                        <td><%=String.valueOf(e.getId())%></td>
                        <td><%=e.getArrivalPlace()%></td>
                        <td><%=e.getDeparturePlace()%></td>
                        <td><%=e.getDepartureTime()%></td>
                        <td><%=e.getArrivalTime()%></td>
                        
                     
                        <td style="border: none;">
                            <div>
                                <form method="post" action="setCrew.jsp">
                                    <input type="hidden" id="setCrew" name="setCrew" value="<%=String.valueOf(e.getId())%>"/> 
                                    <input type="submit" value="Set Crew"/> 
                                </form>
                            </div>
                        </td>
                        <td style="border: none;">

                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
                <h2 style="color: captiontext;text-align: center;margin-top: 40px;margin-bottom: 10px; border:none">
                    Free staff
                </h2>
                    <%@include file="viewCrew.jsp" %>
                 <%@include file="bottom.jsp" %>
    </body>
</html>