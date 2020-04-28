<?php

if (isset($_GET['pageno'])) {
    $pageno = $_GET['pageno'];
} else {
    $pageno = 1;
}
$no_of_records_per_page = 4;

$offset = ($pageno-1) * $no_of_records_per_page;

$con = OpenConnection();

$total_pages_sql = "SELECT COUNT(*) FROM lab7.LogReport";

$res = $con->query($total_pages_sql);
$total_rows = mysqli_fetch_array($res)[0];

$total_pages = ceil($total_rows / $no_of_records_per_page);

$query = "SELECT * FROM lab7.LogReport LIMIT " .$offset .', '. $no_of_records_per_page . ';';
$result_set = $con->query($query);

if(mysqli_num_rows($result_set)>0){
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
    while ($row = mysqli_fetch_array($result_set)){
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
CloseConnection($con);
?>