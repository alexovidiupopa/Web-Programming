<%@ page import="model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 30.04.2020
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>

<%
    List<User> users = (ArrayList<User>)session.getAttribute("users");
    out.println("<table>");
    out.println("<thead>");
    out.println("<th>name</th>");
    out.println("<th>email</th>");
    out.println("<th>age</th>");
    out.println("<th>hometown</th>");
    out.println("<th>picture</th>");
    out.println("</thead>");
    out.println("<tbody>");
    for(User user:users){
        out.println("<tr>");
        out.println("<td>" + user.getName() +"</td>");
        out.println("<td>" + user.getEmail() +"</td>");
        out.println("<td>" + user.getAge() +"</td>");
        out.println("<td>" + user.getHometown() +"</td>");
        out.println("<td>" + user.getPicture() +"</td>");
        out.println("</tr>");
    }
    out.println("</tbody>");
    out.println("</table>");
%>
</body>
</html>
