<?php
require_once('connection.php');
$query = "SELECT c.id, c.titre, c.description, (SELECT gouvernorat FROM villes j WHERE j.id = c.id_ville_depart) AS gouvernorat_depart, (SELECT delegation FROM villes j WHERE j.id = c.id_ville_depart) AS delegation_depart, (SELECT localite FROM villes j WHERE j.id = c.id_ville_depart) AS localite_depart, (SELECT gouvernorat FROM villes j WHERE j.id = c.id_ville_arrivee) AS gouvernorat_arrivee, (SELECT delegation FROM villes j WHERE j.id = c.id_ville_arrivee) AS delegation_arrivee, (SELECT localite FROM villes j WHERE j.id = c.id_ville_arrivee) AS localite_arrivee, co.nom_utilisateur AS conducteur, c.id_createur, date_depart, heure_depart, nombre_places, prix, c.fumeur, reservee_femmes FROM covoiturages c, covoitureurs co WHERE c.id_createur = co.id ORDER BY c.date_creation LIMIT 0 , 10";
$result = mysql_query($query);
if ($result != null) {
    $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    $root_element = "covoiturages";
    $xml .= "<$root_element>";
    while ($result_array = mysql_fetch_assoc($result)) {
        $xml .= "<covoiturage>";
        foreach ($result_array as $key => $value) {
            $xml .= "<$key>";
            $xml .= "$value";
            $xml .= "</$key>";
        }
        $xml .= "</covoiturage>";
    }
    $xml .= "</$root_element>";
    header("Content-Type:text/xml");
    echo $xml;
} else {
    echo "EMPTY SET";
}
?>