<!DOCTYPE html>
<html>
<body>
<p>All reports</p>
<?php include('backend/getallreports.php'); ?>
<br>

<p>Reports using pagination (4 on each page)</p>

<?php include('backend/getreportspagination.php'); ?>
<ul>
    <li><a href="?pageno=1">First</a></li>

    <li>
        <a href="<?php if($pageno > 1){ echo "?pageno=".($pageno - 1); } ?>">Prev</a>
    </li>

    <li>
        <a href="<?php if($pageno < $total_pages){ echo "?pageno=".($pageno + 1); } ?>">Next</a>
    </li>

    <li><a href="?pageno=<?php echo $total_pages; ?>">Last</a></li>
</ul>
<br>

</body>
<html>