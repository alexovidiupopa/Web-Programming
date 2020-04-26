<?php
include ('../db/connection.php');

if (isset($_GET['pageno'])) {
    $pageno = $_GET['pageno'];
} else {
    $pageno = 1;
}
$no_of_records_per_page = 3;

$offset = ($pageno-1) * $no_of_records_per_page;

$connection = OpenConnection();

$total_pages_sql = "SELECT COUNT(*) FROM lab7.LogReport";
$res = $connection->query($total_pages_sql);
$total_rows = mysqli_fetch_array($res)[0];

$total_pages = ceil($total_rows / $no_of_records_per_page);

$query = "SELECT * FROM lab7.LogReport LIMIT " .$offset .', '. $no_of_records_per_page . ';';
$result_set = mysqli_query($connection, $query);

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
    while ($row = mysqli_fetch_array($result_set)){
        echo "<tr>";
        echo "<th>".$row['id']."</th>";
        echo "<th>".$row['username']."</th>";
        echo "<th>".$row['message']."</th>";
        echo "<th>".$row['type']."</th>";
        echo "<th>".$row['severity']."</th>";
        echo "<th>".$row['posted_on']."</th>";
        echo "</tr>";
    }
    echo "</table>";

}
CloseConnection($connection);
?>