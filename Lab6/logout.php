<?php
session_start();
session_destroy();
?>

<!DOCTYPE html>
<html>
<head>
    <title>Logout page</title>
</head>
<body>
<form action = "login.php">
    <input type="submit" name="redirect" value = "Go back to home">
</form>
</body>
</html>