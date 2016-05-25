<?php

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    if (isset($_GET['idDestinataire'])) {
        $idDestinataire = $_GET['idDestinataire'];
        require_once('connect.php');
        $result = mysql_query("SELECT * FROM messages WHERE id_destinataire='" . $idDestinataire . "'");
        if (mysql_num_rows($result) > 0) {
            $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
            $xml .= "<messages>";
            while ($result_array = mysql_fetch_assoc($result)) {
                $xml .= "<message>";
                foreach ($result_array as $key => $value) {
                    $xml .= "<$key>";
                    $xml .= "$value";
                    $xml .= "</$key>";
                }
                $xml.= "</message>";
            }
            $xml .= "</messages>";
            header("Content-Type:text/xml");
            echo $xml;
        } else {
            echo "NO MESSAGES";
        }
    } else {
        echo "ERROR";
    }
} else {
    echo "ERROR";
}