<%@page import="in.techyari.example.dao.FlightDaoIml" %>
<%@page import="in.techyari.example.model.Flight" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styleOther.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
<%@include file="header.jsp"%>
        <div>
            <table align="center" style="margin-top: 100px">
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
                                <form method="post" action="flightUpdate.jsp">
                                    <input type="hidden" id="updateId" name="updateId" value="<%=String.valueOf(e.getId())%>"/> 
                                    <input type="submit" value="Modify"/> 
                                </form>
                            </div>
                        </td>
                        <td style="border: none;">
                            <div>
                                <form method="post" action="DeleteFlightController">
                                    <input type="hidden" id="delId" name="delId" value="<%=String.valueOf(e.getId())%>"/> 
                                    <input type="submit" value="Delete"/> 
                                </form>
                            </div>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
                 <%@include file="bottom.jsp" %>
    </body>
</html>