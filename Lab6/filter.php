<?php
include ('db/connection.php');

$con = OpenConnection();
$sql = "SELECT DISTINCT severity FROM lab7.LogReport";
$result_set = $con->query($sql);
$rows = array();
while ($row = mysqli_fetch_array($result_set, MYSQLI_NUM)) {
    $rows[] = $row[0];
}
$sql2 = "SELECT DISTINCT type FROM lab7.LogReport";
$result_set2 = $con->query($sql2);
$rows2 = array();
while ($row = mysqli_fetch_array($result_set2, MYSQLI_NUM)) {
    $rows2[] = $row[0];
}

CloseConnection($con);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Library</title>
    <script type="text/javascript" src="main.js"></script>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>

<label>
    <select name="Severity Filter" onchange="get_filtered_severity()">
        <option selected>choose severity</option>
        <?php
        foreach ($rows as $row) {
            echo "<option>$row</option>";
        }
        ?>
    </select>
</label>

<table>
    <thead>
    <th>ID</th>
    <th>Author</th>
    <th>Message</th>
    <th>Type</th>
    <th>Severity</th>
    <th>Date</th>
    </thead>
    <tbody>
    </tbody>
</table>

<label>
    <select name="Type Filter" onchange="get_filtered_type()">
        <option selected>choose type</option>
        <?php
        foreach ($rows2 as $row) {
            echo "<option>$row</option>";
        }
        ?>
    </select>
</label>

<table>
    <thead>
    <th>ID</th>
    <th>Author</th>
    <th>Message</th>
    <th>Type</th>
    <th>Severity</th>
    <th>Date</th>
    </thead>
    <tbody>
    </tbody>
</table>

</body>
</html>