<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div id="mystyle" style="border: none;">
            <h1>Aircompany</h1>
      
            <h4> Administation control page </h4>
                <%=new Date()%></br>  </br>
                <a href="flightAddNew.jsp">Add New Flight</a> &NegativeThickSpace; |
                <a href="flightView.jsp">View Flight</a> &NegativeThickSpace;|
		<a href="LoginController?query=logout">Logout</a>
       
        </div>
    </center>
</body>
</html>
