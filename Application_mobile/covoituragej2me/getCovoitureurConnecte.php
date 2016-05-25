<?php   
 
      
 $hostname_localhost ="localhost";  
 $database_localhost ="covoiturage";  
 $username_localhost ="root";  
 $password_localhost ="";  

 $con = mysql_connect($hostname_localhost,$username_localhost,$password_localhost)  
 or  
 trigger_error(mysql_error(),E_USER_ERROR);  
  
      mysql_select_db($database_localhost,$con);  
      $query_search = "SELECT id,email,nom_utilisateur,latitude,longitude FROM covoitureurs WHERE connecte='1'";
      $query_exec = mysql_query($query_search) or die(mysql_error());  
      
if($query_exec!=null){  
      $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
      $root_element = "covoitureurs"; 
      $xml .= "<$root_element>";
	while($result_array = mysql_fetch_assoc($query_exec))
     {
      $xml .= "<covoitureur>";
 
      foreach($result_array as $key => $value)
      {
         //$key holds the table column name
         $xml .= "<$key>";
 
         //embed the SQL data in a CDATA element to avoid XML entity issues
         $xml .= "<![CDATA[$value]]>"; 
 
         //and close the element
         $xml .= "</$key>";
      }
 
      $xml.="</covoitureur>";
   }
//close the root element
$xml .= "</$root_element>";
 
//send the xml header to the browser
header ("Content-Type:text/xml"); 
 
//output the XML data
echo $xml;
 }  
 ?>  