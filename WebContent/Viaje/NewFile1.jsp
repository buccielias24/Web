<!DOCTYPE html>
<html>
<head>
<title>Viajes</title>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
.myLink {display: none}
</style>

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  
<script type="text/javascript">
 $(document).ready(function() {
	 var availableTags=[]
	 $.ajax({
             type:"GET",
             url:"http://localhost:8080/Web/Planetas"
         })
         .done(function (data) {
        	 data.pop();
        	  $.each( data, function( key, val ) {
        	    availableTags.push(val.nombre)
        	  });
         }); 
	 $( function() {
		    $( "#tags" ).autocomplete({
		      source: availableTags
		    });
		   $( "#tags2" ).autocomplete({    
		      source: availableTags
			});
		});
 });
</script>

<script type="text/javascript">
		$(document).on("submit", "#myform", function(event) {
		    var $form = $(this);
		    $.get($form.attr("action"), $form.serialize(), function(data) {
		     if(data.length!=0){
		    	 var html = '<table class="table table-striped">';
		    	    html += '<tr>';
		    	    var flag = 0;
		    	    $.each(data[0], function(index, value){
		    	        html += '<th>'+index+'</th>';
		    	    });
		    	    html += '</tr>';     
		    	     $.each(data, function(index, value){
		    	         html += '<tr>';
		    	            html += '<td>'+value.salida+'</td>';
		    	            html += '<td>'+value.llegada+'</td>';
		    	            html += '<td>'+value.origen.nombre+'</td>';
		    	            html += '<td>'+value.destino.nombre+'</td>';
		    	            html += '<td>'+value.astrobus.id+'</td>';
		    	        html += '<tr>';
		    	     });
		    	     html += '</table>';
		    	     $('#containerTable').html(html);		    	        
		       		}
		     else{alert("No hay viajes disponibles")}
		    });
		    event.preventDefault(); // Important! Prevents submitting the form.		    
		});
		</script>

</head>

<body class="w3-light-grey">

<header>
 <jsp:include page="/header.jsp"></jsp:include>
</header>


<!-- Page content --> 
<!-- Header -->
  <img class="w3-image" src="https://invdes.com.mx/wp-content/uploads/2017/08/06-08-17-universo.jpg" alt="London" width="1500" height="700">
  <div class="w3-display-middle" style="width:65%">
    <div class="w3-bar w3-black">
      <button class="w3-bar-item w3-button tablink"><i class="fa fa-plane w3-margin-right"></i>Flight</button>
    <!-- Tabs -->
    <div id="Flight" class="w3-container w3-white w3-padding-16">
      <h3>Travel the world with us</h3>
      <form id="myform" action="/Web/vistaViaje" method="get"> 
      <div class="w3-row-padding" style="margin:0 -16px;">
        <div class="w3-half">     
          <label>From</label>
          <input id="tags" name="from" class="w3-input w3-border" type="text" placeholder="Departing from">
        </div>
        <div class="w3-half">
          <label>To</label>
          <input id="tags2" name="to" class="w3-input w3-border" type="text" placeholder="Arriving at">
        </div>
      </div>
      <p><button class="w3-button w3-dark-grey" style="margin-top: 10px">Search and find dates</button></p>
    </form>
    </div>
    
    </div>

    
  </div>
  <!-- Table -->
 <div class="container" id="containerTable">
   
</div>
  <!-- End Table -->

<!-- Footer -->
<footer class="w3-container w3-center w3-opacity w3-margin-bottom">
  <h5>Find Us On</h5>
  <div class="w3-xlarge w3-padding-16">
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
    <i class="fa fa-twitter w3-hover-opacity"></i>
    <i class="fa fa-linkedin w3-hover-opacity"></i>
  </div>
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank" class="w3-hover-text-green">w3.css</a></p>
</footer>

</body>
</html>