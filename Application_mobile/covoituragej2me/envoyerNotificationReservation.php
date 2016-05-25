<?php
require_once('connection.php');
  $idExpediteur= $_GET['idExpediteur'];
  $idDestinataire = $_GET['idDestinataire'];
  $contenu = $_GET['contenu'];
  mysql_query("INSERT INTO notifications(id_expediteur, id_destinataire, contenu, type, lu) VALUES (".$idExpediteur.", ".$idDestinataire.", '".$contenu."', 4, 0) ");
  echo "successfully added";
mysql_close();
?>