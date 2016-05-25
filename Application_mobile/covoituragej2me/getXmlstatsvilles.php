<?php   
      require_once('connectCovoiturage.php'); 
  
      mysql_select_db($database_localhost,$con);  
      $query_search ="select c.id_ville_arrivee ,v.gouvernorat as ville,count(v.gouvernorat) as nombre from covoiturages c , villes v where c.id_ville_arrivee=v.id group by v.gouvernorat order by count(v.gouvernorat) DESC";
      $query_exec = mysql_query($query_search) or die(mysql_error());  
      
if($query_exec!=null){  
      $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
      $root_element = "notifications"; 
      $xml .= "<$root_element>";
	while($result_array = mysql_fetch_assoc($query_exec))
     {
      $xml .= "<notification>";
 
      foreach($result_array as $key => $value)
      {
         //$key holds the table column name
         $xml .= "<$key>";
 
         //embed the SQL data in a CDATA element to avoid XML entity issues
         $xml .= "$value"; 
 
         //and close the element
         $xml .= "</$key>";
      }
 
      $xml.="</notification>";
   }
//close the root element
$xml .= "</$root_element>";
 
//send the xml header to the browser
header ("Content-Type:text/xml"); 
 
//output the XML data
echo $xml;
 }  
 ?>  