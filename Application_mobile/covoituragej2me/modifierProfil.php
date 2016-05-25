<?php

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    if ((isset($_GET['id'])) && (isset($_GET['nom'])) && (isset($_GET['prenom'])) && (isset($_GET['email'])) && (isset($_GET['nom_utilisateur']))) {
        $id = $_GET['id'];
        $nom = $_GET['nom'];
        $prenom = $_GET['prenom'];
        $email = $_GET['email'];
        $nom_utilisateur = $_GET['nom_utilisateur'];
        require_once('connect.php');
        if (!mysql_query("UPDATE covoitureurs SET nom='" . $nom . "', prenom='" . $prenom . "', email='" . $email . "', nom_utilisateur='" . $nom_utilisateur . "' WHERE id=" . $id . "")) {
            echo "ERROR";
        } else {
            echo "OK";
        }
    } else {
        echo "ERROR1";
    }
}