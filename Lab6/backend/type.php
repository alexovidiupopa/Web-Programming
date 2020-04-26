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
            $rows[] = new LogReport($row['id'], $row['username'], $row['message'], $row['type'], $row['severity'], $row['posted_on']);

        }
        header('HTTP/1.1 200 OK');
        echo json_encode($rows);
        CloseConnection($con);
        exit;
    }
} catch (Exception $e) {
    echo json_encode(
        array(
            'status' => false,
            'error' => $e->getMessage(),
            'error_code' => $e->getCode()
        )
    );

    exit;
}