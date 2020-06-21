<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 20.06.2020
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery-2.0.3.js"></script>
    <script language="javascript">
        function showAssets(contents) {
            let content = "<table border='1'><tr><th>Id</th><th>Date</th><th>Title</th><th>Description</th><th>Url</th></tr>";
            for (let content2 of contents) {
                let color = "";
                content += "<tr " + color + "><td>" + content2.id + "</td>" +
                    "<td>" + content2.date + "</td>" +
                    "<td>" + content2.title + "</td>" +
                    "<td>" + content2.description+ "</td>" +
                    "<td>" + content2.url + "</td>" +
                    "</tr>";
            }
            console.log(content);
            content += "</table>";
            $("#all-contents").html(content);
        }
        $(document).ready(function () {
            if (JSON.parse(sessionStorage["currentUser"]) !== null) {
                Array.prototype.pushArray = function (arr) {
                    this.push.apply(this, arr);
                };
                let id = JSON.parse(sessionStorage["currentUser"])["userId"];
                var contents = [];
                var newAssets = [];
                $(function () {
                    $.getJSON(
                        "/content", {action: "getMostRecent", userId: id}, function (data, status) {
                            console.log(data);
                            contents.pushArray(data["contents"]);
                            showAssets(contents);
                        }
                    )
                });
            } else {
                location.href = "login.jsp";
            }
        });
        </script>
</head>
<body>
<section id="all-contents"></section>
</body>
</html>
