<%@ page import="model.Asset" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 18.06.2020
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <script src="main.js"></script>
    <link rel="stylesheet" href="main.css" type="text/css">
    <script src="jquery-2.0.3.js"></script>
</head>
<body>
<form action="LogoutServlet" method="post">
    <input type="submit" name="logout" value="Logout">
</form>
<h2>User assets</h2>
<%
    int user_id = (int) session.getAttribute("userId");
    String username = (String) session.getAttribute("username");
    List<Asset> assets = (ArrayList<Asset>)session.getAttribute("assets");
    for (Asset asset:assets){
        out.println("<ul>");
        if (asset.getValue()>10){
            out.println("<li class='red'>" + asset.toString() + "</li>");
        }
        else {
            out.println("<li>" + asset.toString() + "</li>");
        }
        out.println("</ul>");
    }
%>
<h2>Add:</h2>
<div>
    <input name="name" type="text" id="name-input" placeholder="name">
    <input name="description" type="text" id="description-input" placeholder="description">
    <input name="value" type="text" id="value-input" placeholder="value">
    <button type="button" onclick="push()">Push</button>
    <button type="button" onclick="add(<%out.println("'" + session.getAttribute("userId") + "'");%>)">Add</button>
    <br>
</div>
<br>
</body>
</html>
