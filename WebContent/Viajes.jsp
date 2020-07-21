<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8">
<title>Insert title here</title>
 
 <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
 <script src="js/jquery.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
 
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet">
  
 <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
 
 <script type="text/javascript">
		$(document).on("submit", "#myform", function(event) {
		    var $form = $(this);
		    $.get($form.attr("action"), $form.serialize(), function(data) {
		     if(data.length!=0){
		    	 var html = '<div class="card w-75" style="margin:auto; margin-top:10px"><div class="card-body"><div class="table-responsive"><table class="table table-striped">';
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
		    	     html += '</table></div></div></div>';
		    	     $('#tablaViajes').html(html);		    	        
		       		}
		     else{alert("No hay viajes disponibles")}
		    });
		    event.preventDefault(); // Important! Prevents submitting the form.		    
		});
		</script>
 <style>
 body{
	background:url(https://wallpapercave.com/wp/wp3493593.jpg);
    background-size: cover;
	}
	
  h1{
	color:#ffffff;
	font-family: 'Roboto';
	font-size:22px;	
  }
 </style>
 
  
</head>
<header>
<jsp:include page="/header2.jsp"></jsp:include>
</header>
<body class="text-center">
  <div class="container-fluid">
	<div class="row">
	   <div class="col-md-12">
	   <h1>Viaje por el universo con nosotros</h1></div>
	      <div class="col-md-12">
		   <div class="card w-75" style="margin:auto;">
  	     	 <div class="card-body"><h2>Buscador de Viajes</h2>	
			  <form id="myform" action="/Web/vistaViaje" method="get"> 
			   <div class="row">  
				 <div class="col-md-6">
				  <div class="input-group mb-3">
  				   <div class="input-group-prepend">
    			    <span class="input-group-text" id="inputGroup-sizing-default">Origen</span>
  				   </div>
  				    <input name="from" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                  </div>  	
				 </div>	
				 <div class="col-md-6">
			      <div class="input-group mb-3">
                   <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Destino</span>
                   </div>
                    <input name="to" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                  </div>			
				 </div>
			 </div>		
				 <div class="col-md-12" style="left: 0%;">
				  <button class="btn btn-primary">Buscar y Buscar Fechas</button>
    			 </div>   			    
  	        </form>
  	       </div>
	    </div>
	 </div>
  </div>
	<div class="row">
		<div id="tablaViajes" class="col-md-12">
		
		</div>
	</div>
</div>
</body>
</html>