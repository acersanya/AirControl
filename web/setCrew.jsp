<%@page import="in.techyari.example.dao.UserDAOImpl" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    <head>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="style.css">
        <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styleOther.css" rel="stylesheet" type="text/css"/>
        <title>New Flight</title>
    </head>
    <body>

  <jsp:useBean id="obj" class="in.techyari.example.dao.UserDAOImpl" scope="page"/>
  <jsp:useBean id="flightObj" class="in.techyari.example.model.Flight" scope="page"/>
  <% int id = Integer.parseInt(request.getParameter("setCrew")); %>
      

        <div id="mystyle" class="myform2" style="margin-top: 200px;" >
            <h1>Set crew For flight id : <%=id%>  </h1>
        
                <p>To add new Crew choose following information</p>
        <form method="POST" action="AddNewCrew" id="setCrew">
      
       
        <select name="captainPos" id="captainPos" class="captainPos">
            <c:forEach var="item" items="${obj.users}">
                <c:if test="${item.getPosition()=='captain'}">
                    <option value=" ${item.getId()}">${item}</option>   
                </c:if> 
            </c:forEach>
        </select>
        
            <select name="secondOfficerPos" id="secondOfficerPos" class="secondOfficerPos"> 
            <c:forEach var="item" items="${obj.users}">
                <c:if test="${item.getPosition()=='Second officer'}">
                    <option value="${item.getId()}">${item}</option>   
                </c:if> 
            </c:forEach>
        </select>
         
            <select name="firstOfficerPos" id="firstOfficerPos" class="firstOfficerPos">
            <c:forEach var="item" items="${obj.users}">
                <c:if test="${item.getPosition()=='First officer'}">
               <option value="${item.getId()}">${item}</option>   
                </c:if> 
            </c:forEach>
        </select>
        
        <input type="submit" value="Create Crew">
        </form>
        </div>
        <div style="margin-top: 220px;">
        <%@include file="bottom.jsp"%>
        </div>
    </body>
</html>