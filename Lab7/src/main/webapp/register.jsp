<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 30.04.2020
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="RegisterServlet" method="post">
    Enter username : <input type="text" name="username"> <BR>
    Enter password : <input type="password" name="password"> <BR>
    Enter name : <input type="text" name="name"> <BR>
    Enter email : <input type="text" name="email"> <BR>
    Enter picture : <input type="text" name="picture"> <BR>
    Enter age : <input type="text" name="age"> <BR>
    Enter hometown : <input type="text" name="hometown"> <BR>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
