<?php

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    if ((isset($_GET['email'])) && (isset($_GET['password']))) {
        $email = $_GET['email'];
        $password = md5($_GET['password']);
        require_once('connect.php');
        $result = mysql_query("select covoitureurs.id,covoitureurs.mdp,covoitureurs.nom_utilisateur,covoitureurs.email,covoitureurs.nom,covoitureurs.prenom,covoitureurs.fumeur, covoitureurs.date_naissance, covoitureurs.date_enregistrement, covoitureurs.note, covoitureurs.etat, covoitureurs.avatar, covoitureurs.skype, covoitureurs.facebook, covoitureurs.date_derniere_visite, covoitureurs.cle_activation, covoitureurs.latitude, covoitureurs.longitude, covoitureurs.connecte from covoitureurs WHERE email='" . $email . "' AND mdp='" . $password . "'");
        if (mysql_num_rows($result) > 0) {
            $xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>";
            while ($result_array = mysql_fetch_assoc($result)) {
                $xml .= "<covoitureur>";
                foreach ($result_array as $key => $value) {
                    $xml .= "<$key>";
                    $xml .= "$value";
                    $xml .= "</$key>";
                }
                $xml.="</covoitureur>";
            }
            header("Content-Type:text/xml");
            echo $xml;
        } else {
            echo "ERROR";
        }
    } else {
        echo "ERROR";
    }
} else {
    echo "ERROR";
}