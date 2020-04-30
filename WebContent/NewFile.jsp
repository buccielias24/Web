<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
<script type="text/javascript">
 $(document).ready(function() {
	 var availableTags=[]
      $.ajax({
             type:"GET",
             url:"http://localhost:8080/Web/Planetas"
         })
         .done(function (data) {
        	  $.each( data, function( key, val ) {
        	    availableTags.push(val.nombre,val.id)
        	  });
         });
	 
	 $( function() {
		    $( "#tags" ).autocomplete({
		      source: availableTags
		    });
		  } );
	
	 $( function() {
		    $( "#tags2" ).autocomplete({
		      source: availableTags
		    });
		  } );
 });

</script>


</head>
<body>
 <div class="ui-widget">
  <label for="tags">Origen: </label>
  <input id="tags">
  <label for="tags">Destinon: </label>
  <input id="tags2">
</div>
</body>
</html>
