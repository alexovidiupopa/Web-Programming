<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 18.06.2020
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="jquery-2.0.3.js"></script>

    <script language="javascript">
        $(document).ready(function () {
            sessionStorage.setItem("currentUser", null);
            $("#login-button").click(function () {
                if ($('#user').val().length && $('#password').val().length) {
                    $.post(
                        "/login",
                        {
                            action: "login",
                            user: $('#user').val(),
                            password: $('#password').val()
                        },
                        function (data, success) {
                            data = JSON.parse(data);
                            console.log(data);
                            if (data["success"] === true) {
                                let temp = {userId: data["userId"]};
                                sessionStorage.setItem("currentUser", JSON.stringify(temp));
                                console.log(JSON.parse(sessionStorage["currentUser"]));
                                location.href = 'homepage.jsp';
                            } else {
                                $("#error").html('<h4 style="color: red;">Bad credentials!</h4>');
                            }
                        }
                    );
                } else {
                    alert("Both fields should be non-empty!")
                }
            });
        });
    </script>
</head>
<body>
<h3>Login</h3>
<form>
    <label for="user">Username:</label>
    <input type="text" id="user" name="user"><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br><br>
    <button type="button" id="login-button">Login</button>
</form>
<section id="error">
</section>
</body>
</html>
