<?php

function OpenConnection(): mysqli
{
    $dbhost = "127.0.0.1";
    $dbusername = "alex";
    $dbpassword = "alex";
    $dbname = "phplab";

    return mysqli_connect($dbhost, $dbusername, $dbpassword, $dbname);
}

function CloseConnection(mysqli $con)
{
    $con->close();
}