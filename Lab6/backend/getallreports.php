<?php
include ('./db/connection.php');

$connection = OpenConnection();

$query = "SELECT * FROM lab7.LogReport";
$result = $connection->query($query);

if(mysqli_num_rows($result)>0){
    echo "<table>";
    echo "<thead>";
    echo "<th>ID</th>";
    echo "<th>Author</th>";
    echo "<th>Message</th>";
    echo "<th>Type</th>";
    echo "<th>Severity</th>";
    echo "<th>Date Posted</th>";
    echo "</thead>";
    echo "<tbody>";
    while ($row = mysqli_fetch_array($result)){
        echo "<tr>";
        echo "<th>".$row['id']."</th>";
        echo "<th>".$row['user_id']."</th>";
        echo "<th>".$row['message']."</th>";
        echo "<th>".$row['type']."</th>";
        echo "<th>".$row['severity']."</th>";
        echo "<th>".$row['posted_on']."</th>";
        echo "</tr>";
    }
    echo "</tbody>";
    echo "</table>";

}

CloseConnection($connection);
?>