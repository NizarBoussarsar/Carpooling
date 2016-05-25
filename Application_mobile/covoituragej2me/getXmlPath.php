<?php   
      require_once('connectCovoiturage.php'); 
  
      mysql_select_db($database_localhost,$con);  
      //$query_search = "SELECT * FROM covoiturages";  
//http://localhost/getXmlPath.php?id=1 
$id = $_GET['id'];     
$query_search = "SELECT v.id, v.longitude, v.latitude
FROM villes v
INNER JOIN covoiturages c ON ( c.id_ville_depart = v.id
OR c.id_ville_arrivee = v.id ) 
Where c.id=$id";

      $query_exec = mysql_query($query_search) or die(mysql_error());  
      
if($query_exec!=null){  
      $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
      $root_element = "Villes"; 
      $xml .= "<$root_element>";
	while($result_array = mysql_fetch_assoc($query_exec))
     {
      $xml .= "<Ville>";
 
      foreach($result_array as $key => $value)
      {
         //$key holds the table column name
         $xml .= "<$key>";
 
         //embed the SQL data in a CDATA element to avoid XML entity issues
         $xml .= "<![CDATA[$value]]>"; 
 
         //and close the element
         $xml .= "</$key>";
      }
 
      $xml.="</Ville>";
   }
//close the root element
$xml .= "</$root_element>";
 
//send the xml header to the browser
header ("Content-Type:text/xml"); 
 
//output the XML data
echo $xml;
 }  
 ?>  