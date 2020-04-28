<?php
include ('../db/connection.php');
include ('../db/LogReport.php');

try {
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $con = OpenConnection();
        $type = json_decode(file_get_contents('php://input'), true)['type'];

        if ($type !== false && $type !== "choose type") {
            $sql = sprintf("SELECT * FROM lab7.LogReport WHERE type = '%s'", $type);
        } else {
            $sql = "SELECT * FROM lab7.LogReport";
        }

        $result_set = $con->query($sql);
        $rows = array();
        while ($row = mysqli_fetch_array($result_set)) {
            $rows[] = new LogReport($row['id'], $row['user_id'], $row['message'], $row['type'], $row['severity'], $row['posted_on']);

        }
        header('HTTP/1.1 200 OK');
        echo json_encode($rows);
        CloseConnection($con);
        exit;
    }
} catch (Exception $e) {
    header('HTTP/1.1 500 INTERNAL_SERVER_ERROR');
    exit;
}