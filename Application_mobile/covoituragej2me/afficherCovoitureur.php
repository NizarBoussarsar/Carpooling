<?php

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $id = $_GET['id'];
    require_once('connection.php');
    $result = mysql_query("SELECT nom_utilisateur FROM covoitureurs WHERE id = " . $id . "");
    if ($result != null) {
        $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        while ($result_array = mysql_fetch_assoc($result)) {
            $xml .= "<covoitureur>";
            foreach ($result_array as $key => $value) {
                $xml .= "<$key>";
                $xml .= "$value";
                $xml .= "</$key>";
            }
            $xml .= "</covoitureur>";
        }
        header("Content-Type:text/xml");
        echo $xml;
    } else {
        echo "EMPTY SET";
    }
} else {
    echo "ERROR - REQUEST METHOD GET NOT FOUND";
}
?>