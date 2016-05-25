<?php   
      require_once('connectCovoiturage.php'); 
  
      mysql_select_db($database_localhost,$con);  
      $id=$_GET['id'];
      $query_search ="SELECT SUM(prix) AS price, SUBSTRING(date_participation,1,7) AS datep, id_participant FROM participants p, covoiturages c WHERE id_participant = $id AND p.id_covoiturage = c.id GROUP BY datep ORDER BY date_participation LIMIT 0, 30 ";
      $query_exec = mysql_query($query_search) or die(mysql_error());  
      
if($query_exec!=null){  
      $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
      $root_element = "statsprix"; 
      $xml .= "<$root_element>";
	while($result_array = mysql_fetch_assoc($query_exec))
     {
      $xml .= "<statprix>";
 
      foreach($result_array as $key => $value)
      {
         //$key holds the table column name
         $xml .= "<$key>";
 
         //embed the SQL data in a CDATA element to avoid XML entity issues
         $xml .= "$value"; 
 
         //and close the element
         $xml .= "</$key>";
      }
 
      $xml.="</statprix>";
   }
//close the root element
$xml .= "</$root_element>";
 
//send the xml header to the browser
header ("Content-Type:text/xml"); 
 
//output the XML data
echo $xml;
 }  
 ?>  