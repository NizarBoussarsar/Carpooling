<?php
$username = "root";
$password = "";
$hostname = "localhost"; 

$dbhandle = mysql_connect($hostname, $username, $password) or die("Unable to connect to MySQL");

$selectDB = mysql_select_db("covoiturage",$dbhandle) or die("Could not select the database");
?>