<?php
require_once('connection.php');
  $idCovoitureur = $_GET['idCovoitureur'];
  $idCovoiturage = $_GET['idCovoiturage'];
  mysql_query("INSERT INTO reservations(id_covoitureur, id_covoiturage, etat) VALUES (".$idCovoitureur.", ".$idCovoiturage.", 0) ");
  echo "successfully added";
mysql_close();
?>