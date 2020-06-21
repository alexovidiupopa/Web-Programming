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
    <title>contents</title>
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
                        "/content", {action: "getAll", userId: id}, function (data, status) {
                            console.log(data);
                            contents.pushArray(data["contents"]);
                            showAssets(contents);
                        }
                    )
                });
                $("#send-button").click(function () {
                    $.post(
                        "/content",
                        {action: "addContents", newContentsToAdd: JSON.stringify(newAssets)},
                        function (data) {
                            location.reload();
                        }
                    );
                    newAssets = [];
                    $("#contents-array").val("");
                });
                $("#push-button").click(function () {
                    newAssets.push({
                        userId: id,
                        title: $("#name").val(),
                        description: $("#description").val(),
                        url: $("#value").val()
                    });
                    $("#name").val("");
                    $("#description").val("");
                    $("#value").val("");
                    let content = "<h4>contents to add:<br>";
                    for (let tempAsset of newAssets) {
                        content += "<b>" + tempAsset["title"] + ",</b> "
                    }
                    content += "</h4>";
                    $("#contents-array").html(content);
                });
                $("#delete-button").click(function () {
                    let cid = $("#id").val();
                    $.post(
                        "/content",
                        {action: "deleteContent", contentId:cid, userId: id},
                        function (data) {
                            location.reload();
                        }
                    );
                });
            } else {
                location.href = "login.jsp";
            }
        });
    </script>
</head>
<body>
<h1>Home</h1>
<form>
    <label for="Name">Title:</label>
    <input type="text" id="name" name="name"><br><br>
    <label for="Description">Description:</label>
    <input type="text" id="description" name="description"><br><br>
    <label for="Value">Url:</label>
    <input type="text" id="value" name="value"><br><br>
    <button type="button" id="push-button">Push</button>
    <button type="button" id="send-button">Send</button>
    <label for="Id">Id:</label>
    <input type="text" id="id" name="id"><br><br>
    <button type="button" id="delete-button">Delete</button>
</form>

<section id="all-contents">
</section>
<section id="contents-array">
</section>
</body>
</html>
