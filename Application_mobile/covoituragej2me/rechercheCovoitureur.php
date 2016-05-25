<?php

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    if (isset($_GET['critere'])) {
        $critere = $_GET['critere'];
        require_once('connect.php');
        $result = mysql_query("SELECT covoitureurs.id,covoitureurs.mdp,covoitureurs.nom_utilisateur,covoitureurs.email,covoitureurs.nom,covoitureurs.prenom,covoitureurs.fumeur, covoitureurs.date_naissance, covoitureurs.date_enregistrement, covoitureurs.note, covoitureurs.etat, covoitureurs.avatar, covoitureurs.skype, covoitureurs.facebook, covoitureurs.date_derniere_visite, covoitureurs.cle_activation, covoitureurs.latitude, covoitureurs.longitude, covoitureurs.connecte FROM covoitureurs WHERE nom LIKE '%" . $critere . "%' or prenom LIKE '%" . $critere . "%' or email LIKE '%" . $critere . "%' or nom_utilisateur LIKE '%" . $critere . "%'");

        if (mysql_num_rows($result) > 0) {
            $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
            $xml .= "<covoitureurs>";
            while ($result_array = mysql_fetch_assoc($result)) {
                $xml .= "<covoitureur>";
                foreach ($result_array as $key => $value) {
                    $xml .= "<$key>";
                    $xml .= "$value";
                    $xml .= "</$key>";
                }
                $xml.= "</covoitureur>";
            }
            $xml .= "</covoitureurs>";
            header("Content-Type:text/xml");
            echo $xml;
        } else {
            echo "NOT FOUND";
        }
    } else {
        echo "ERROR";
    }
}
