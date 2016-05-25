<?php   
      require_once('connectCovoiturage.php'); 
  
      mysql_select_db($database_localhost,$con);  
      //$query_search = "SELECT * FROM covoiturages";  
//http://localhost/getXmlCovoiturages.php?critere=Sfax&criteree=t  
$critere = $_GET['critere'];     
$criteree = $_GET['criteree']; 

$query_search = "SELECT DISTINCT c.id, c.id_createur, c.titre,c.description,c.id_ville_depart,c.id_ville_arrivee
FROM covoiturages c
LEFT JOIN detours d ON ( c.id = d.id_covoiturage ) 
INNER JOIN villes ON ( villes.id = d.id_ville
OR c.id_ville_depart = villes.id
OR c.id_ville_arrivee = villes.id ) 
WHERE (villes.gouvernorat LIKE  '%".$critere."%'
OR villes.delegation LIKE '%".$critere."%'
OR c.titre LIKE '%".$critere."%'
OR c.description LIKE '%".$critere."%'
OR villes.delegation LIKE '%".$critere."%' 
OR villes.delegation LIKE '%".$criteree."%' 
OR c.description LIKE '%".$criteree."%'
OR c.titre LIKE '%".$criteree."%'
OR villes.gouvernorat LIKE  '%".$criteree."%')";

      $query_exec = mysql_query($query_search) or die(mysql_error());  
      
if($query_exec!=null){  
      $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
      $root_element = "covoiturages"; 
      $xml .= "<$root_element>";
	while($result_array = mysql_fetch_assoc($query_exec))
     {
      $xml .= "<covoiturage>";
 
      foreach($result_array as $key => $value)
      {
         //$key holds the table column name
         $xml .= "<$key>";
 
         //embed the SQL data in a CDATA element to avoid XML entity issues
         $xml .= "<![CDATA[$value]]>"; 
 
         //and close the element
         $xml .= "</$key>";
      }
 
      $xml.="</covoiturage>";
   }
//close the root element
$xml .= "</$root_element>";
 
//send the xml header to the browser
header ("Content-Type:text/xml"); 
 
//output the XML data
echo $xml;
 }  
 ?>  