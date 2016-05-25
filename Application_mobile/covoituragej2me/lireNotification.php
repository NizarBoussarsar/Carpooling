 <?php
require_once('connectCovoiturage.php');

mysql_select_db($database_localhost,$con);

 $id=$_GET['id'];
mysql_query("UPDATE notifications set lu=1 where id=$id ");
echo "notification lu";
?>