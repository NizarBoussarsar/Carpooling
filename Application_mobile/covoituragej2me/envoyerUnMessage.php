<?php

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    if ((isset($_GET['idExpediteur'])) && (isset($_GET['idDestinataire'])) && (isset($_GET['contenu']))) {
        $idExpediteur = $_GET['idExpediteur'];
        $idDestinataire = $_GET['idDestinataire'];
		$objet = $_GET['objet'];
        $contenu = $_GET['contenu'];
        require_once('connect.php');
        if(!mysql_query("INSERT INTO messages (id_expediteur,id_destinataire,objet,contenu) VALUES ('" . $idExpediteur . "','" . $idDestinataire ."','" . $objet . "','" . $contenu . "')")) {
            echo "ERROR";
        } else {
            echo "OK";
        }
    } else {
        echo "ERROR";
    }
}