<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Travel modes in directions</title>
    <style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
        #panel {
        position: absolute;
        top: 5px;
        left: 50%;
        margin-left: -180px;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        borderLongitude: 1px solid #999;
      }
    </style>
    <script type="text/javascript">
     var departLongitude ='<?php echo $_GET["dlong"] ; ?>' ;
     var departLattitude ='<?php echo $_GET["dlat"] ; ?>';
     var arriveeLongitude ='<?php echo $_GET["along"] ; ?>' ;
     var arriveeLattitude ='<?php echo $_GET["alat"] ; ?>';
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=true"></script>
    <script>

var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;
var haight =departLattitude+", "+departLongitude+", Tunisie";
var oceanBeach =arriveeLattitude+", "+arriveeLongitude+", Tunisie";
function initialize() {
  directionsDisplay = new google.maps.DirectionsRenderer();
  var mapOptions = {
    zoom:10,
  }
  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
  directionsDisplay.setMap(map);
}
/*
http://localhost/covoiturage/map.php?dlat=34.74516&dlong=10.76130&alat=37.27626&along=9.87307*/
function calcRoute() {

  var selectedMode = document.getElementById('mode').value;
  var request = {
      origin:haight,
      destination: oceanBeach,
       
     
      optimizeWaypoints: true,
      travelMode: google.maps.TravelMode[selectedMode]
  };
  directionsService.route(request, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
    }
  });
}

google.maps.event.addDomListener(window, 'load', initialize);

    </script>
  </head>
  <body onload="calcRoute();">
    <div id="panel">
    <b>Mode of Travel: </b>
    <select id="mode" onchange="calcRoute();">
      <option value="DRIVING">Driving</option>
    </select>
    </div>
    <div id="map-canvas"></div>
  </body>
</html>