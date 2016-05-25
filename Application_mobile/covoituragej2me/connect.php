<?php

$host = "localhost";

$user = "root";

$db = "covoiturage";

$pwd = "";

mysql_connect($host, $user, $pwd) or die('ERROR ' . mysql_error());

mysql_select_db($db) or die('ERROR ' . mysql_error());
