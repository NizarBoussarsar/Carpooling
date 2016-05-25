<?php

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    if (isset($_GET['idCovoitureur'])) {
        $idCovoitureur = $_GET['idCovoitureur'];
        require_once('connect.php');
        $result = mysql_query("SELECT covoitureurs.id,covoitureurs.mdp,covoitureurs.nom_utilisateur,covoitureurs.email,covoitureurs.nom,covoitureurs.prenom,covoitureurs.fumeur, covoitureurs.date_naissance, covoitureurs.date_enregistrement, covoitureurs.note, covoitureurs.etat, covoitureurs.avatar, covoitureurs.skype, covoitureurs.facebook, covoitureurs.date_derniere_visite, covoitureurs.cle_activation, covoitureurs.latitude, covoitureurs.longitude, covoitureurs.connecte FROM covoitureurs WHERE id=" . $idCovoitureur . "");

        while ($result_array = mysql_fetch_array($result)) {
            echo $result_array['prenom'] . " " . $result_array['nom'];
        }
    } else {
        echo "ERROR";
    }
}