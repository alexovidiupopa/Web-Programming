<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 30.04.2020
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    out.println("Welcome "+user.getUsername());
    out.println("<ul>");
    out.println("<li>" + user.getUsername() + "</li>");
    out.println("<li>" + user.getName() + "</li>");
    out.println("<li>" + user.getEmail() +"</li>");
    out.println("<li><img src=\"" + user.getPicture() + "\"></li>");
    out.println("<li>"  + user.getAge() + "</li>");
    out.println("<li>" + user.getHometown()  + "</li>");
    out.println("</ul>");
%>
<form action="SearchServlet" method="get">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="email" placeholder="email">
    <input type="text" name="age" placeholder="><=age">
    <input type="text" name="hometown" placeholder="hometown">
    <input type="submit" value="Search!"/>
</form>
</body>
</html>
