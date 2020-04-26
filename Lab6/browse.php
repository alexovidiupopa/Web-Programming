<!DOCTYPE html>
<html>
<body>
<p>All reports</p>
<?php include('backend/getallreports.php'); ?>
<br>

<p>Reports using pagination (3 on each page)</p>

<?php include('backend/getreportspagination.php'); ?>
<ul>
    <li><a href="?pageno=1">First</a></li>
    <li class="<?php if($pageno <= 1){ echo 'disabled'; } ?>">
        <a href="<?php if($pageno <= 1){ echo '#'; } else { echo "?pageno=".($pageno - 1); } ?>">Prev</a>
    </li>
    <li class="<?php if($pageno >= $total_pages){ echo 'disabled'; } ?>">
        <a href="<?php if($pageno >= $total_pages){ echo '#'; } else { echo "?pageno=".($pageno + 1); } ?>">Next</a>
    </li>
    <li><a href="?pageno=<?php echo $total_pages; ?>">Last</a></li>
</ul>
<br>

</body>
<html>