<%@page import="in.techyari.example.dao.UserDAOImpl" %>
<%@page import="in.techyari.example.model.User" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>View Crew</title>
    </head>
    <body>
        <div>
            <table align="center" style="margin-top: 30px"> 
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Fullname</th>
                        <th>Surname</th>
                        <th>gender</th>
                        <th>birthday</th>
                        <th>position</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        UserDAOImpl userDao = new UserDAOImpl();
                        List<User> userList = userDao.getUsers();
                        for (User e : userList) {
                            if (e.getStatusAvaible() == 0) {
                                continue;
                            }
                    %>
                    <tr>
                        <td><%=String.valueOf(e.getId())%></td>
                        <td><%=e.getFullname()%></td>
                        <td><%=e.getSurname()%></td>
                        <td><%=e.getGender()%></td>  
                        <td><%=e.getBirthdate()%></td>  
                        <td><%=e.getPosition()%></td>
                        <%
                            }
                        %>
                </tbody>
            </table>
        </div>

    </body>
</html>