<%@page import="java.util.List"%>
<%@page import="data.DataResenia"%>
<%@page import="logic.reseniaController"%>
<%@page import="entidades.Resenia"%>
<%@page import="entidades.Ciudadano"%>
<%@page import="entidades.Planeta"%>
<%@page import="logic.PlanetaControler"%>
<%@page import="java.util.ArrayList"%>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Planetas</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/grid/">

    <!-- Bootstrap core CSS -->
<link href="/Web/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="/Web/css/grid.css" rel="stylesheet">


  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
 <script type="text/javascript">
 <!-- Agrega los planetas a la tabla	 -->
 $(document).ready(function() {
      $.ajax({
             type:"GET",
             url:"http://localhost:8080/Web/Planetas"
         })
         .done(function (data) {
        	 var last = data[data.length - 1];
        	 if(last==null){
        		 data.pop();
        		 $.each( data, function( key, val ) {		  
           		  tr = $('<tr class="text-center"/>');
                     tr.append("<td>" + val.id + "</td>");
                     tr.append("<td>" + val.nombre + "</td>");  
                     tr.append("<td>" + val.estado + "</td>");
                     $('#tablebody').append(tr);
           	  }); 
   			  }else{
   				$('#newPlaneta').append('<button id="new" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"><span class="oi oi-plus"></span></button>');
   				data.pop();
   				$('#trhead').append('<th>Acciones</th>'); 
   				$.each( data, function( key, val ) {		  
             		  tr = $('<tr class="text-center"/>');
                       tr.append("<td>" + val.id + "</td>");
                       tr.append("<td>" + val.nombre + "</td>");  
                       tr.append("<td>" + val.estado + "</td>");
                       tr.append("<td>" + '<button type="button" id="trigger_modal" class="btn btn-primary" data-toggle="modal" data-target="#myModal2">Editar</button>' + '<button style="margin-left:10px" id="delete" type="button" class="btn btn-danger">Eliminar</button>' +"</td>");        
                       $('#tablebody').append(tr);
             	  }); 
   			  }
         });
 });
</script>  
    
<script type="text/javascript">
		$(document).on("submit", "#form", function(event) {
		    var $form = $(this);
		    $.post($form.attr("action"), $form.serialize(), function(response) {    	
		    	$("#tablebody").empty();
		    	 	$.each( response, function( key, val ) {
	        		  tr = $('<tr class="text-center"/>');
	                  tr.append("<td>" + val.id + "</td>");
	                  tr.append("<td>" + val.nombre + "</td>");  
	                  tr.append("<td>" + val.estado + "</td>");
	                  tr.append("<td>" + '<button type="button" id="trigger_modal" class="btn btn-primary" data-toggle="modal" data-target="#myModal2">Editar</button>' + '<button style="margin-left:10px" id="delete" type="button" class="btn btn-danger">Eliminar</button>' +"</td>");
	                  $('#tablebody').append(tr);
		    	 	});
		    	 	alert("Planeta actualizado");
		    });
		    event.preventDefault(); // Important! Prevents submitting the form.	    
		});
</script>


<script>
$(document).ready(function(){
	  $(".thehide").hide();
	  $(document).on("click", "table button", function(){
	   // $("#trigger_modal").trigger("click");
	    $("#myModal2 .modal-body").html($("#partial_container").html());
	    $('#myModal2 input[name="nombreP"]').val($(this).closest("tr").find("td:nth-child(1)").text());
	    $('#myModal2 input[name="coordX"]').val($(this).closest("tr").find("td:nth-child(2)").text());
	    $('#myModal2 input[name="coordY"]').val($(this).closest("tr").find("td:nth-child(3)").text());
	  });	  
});	
</script>

</head>
  
  
<header>
 <jsp:include page="/header.jsp"></jsp:include>
</header>
  
  <!-- LLAMAR AL CERRAR SESION  -->
    <form action="/Web/logout" method="post">
    <input id="logout" type="submit" value="logout"/> 
    </form>
    
<body class="py-4">
<div class="container">
    <div class="card">
        <div class="card-header">
            <h3 class="text-center">Planetas</h3>
            	<div class="text-right" id="newPlaneta"> </div>
            <div class="card-body">
                <table class="table table-hover">
                    <thead> 
                        <tr class="text-center" id="trhead">
                            <th>Nombre</th>
                            <th>Coordenada</th>
                            <th>Disponibilidad</th>               
                        </tr>
                    </thead>
                    <tbody id="tablebody">  
                    	
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- MODAL NUEVO PLANETA -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title" align="center">Nuevo</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
  		<form action="/Web/Planetas" method="post" name="form" id="form" enctype="multipart/form-data">
			 <input type="hidden" value="new" name="accion">
			 <div class="form-group row">
    		    <label for="inputNombre" class="col-sm-2 col-form-label">Nombre</label>
   					<div class="col-sm-10">
   						<input type="text" class="form-control" id="inputNombre" name="nombreP" placeholder="Nombre Planeta">
    				</div>
  			</div>
  			<div class="form-group row">
  			   <label for="inputCoordenadaX" class="col-sm-2 col-form-label">CoordX</label>
    				<div class="col-sm-10">
     					<input type="text" class="form-control" id="inputCoordenadaX" name="coordX" placeholder="Coordenada X">
    				</div>
  			</div>
  			<div class="form-group row">
  			   <label for="inputCoordenadaY" class="col-sm-2 col-form-label">CoordY</label>
    				<div class="col-sm-10">
     					<input type="text" class="form-control" id="inputCoordenadaY" name="coordY" placeholder="Coordenada Y">
    				</div>
  			</div>
  			<div class="form-group row">
  			   <label for="descripcion" class="col-sm-2 col-form-label">Descripcion</label>
    				<div class="col-sm-10">
     					<input type="text" class="form-control" id="descripcion" placeholder="escriba la descripcion del planeta">
    				</div>
  			</div>
  			<button type="submit" class="btn btn-primary">Guardar</button>
		</form>			
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>

<!-- MODAL EDITAR --> 

<!-- Modal -->
<div class="modal" id="myModal2">
  <div class="modal-dialog">
    <div class="modal-content">
    
 <!-- Modal Header -->     
      <div class="modal-header">
        <h4 class="modal-title" align="center">Edit</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      </div>
     
     
      <div class="modal-body">  
      </div>
      
      <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- the partial container -->

<div class="thehide" id="partial_container">
  <form id="myform2" action="/java-examen/editaralumno" method="post">
			 <div class="form-group row">
    		    <label for="inputNombre" class="col-sm-2 col-form-label">Nombre</label>
   					<div class="col-sm-10">
   						<input type="text" class="form-control" id="inputNombre" name="nombreP" placeholder="Nombre Planeta">
    				</div>
  			</div>
  			<div class="form-group row">
  			   <label for="inputCoordenadaX" class="col-sm-2 col-form-label">CoordX</label>
    				<div class="col-sm-10">
     					<input type="text" class="form-control" id="inputCoordenadaX" name="coordX" placeholder="Coordenada X">
    				</div>
  			</div>
  			<div class="form-group row">
  			   <label for="inputCoordenadaY" class="col-sm-2 col-form-label">CoordY</label>
    				<div class="col-sm-10">
     					<input type="text" class="form-control" id="inputCoordenadaY" name="coordY" placeholder="Coordenada Y">
    				</div>
  			</div>
  			<div class="form-group row">
  			   <label for="descripcion" class="col-sm-2 col-form-label">Descripcion</label>
    				<div class="col-sm-10">
     					<input type="text" class="form-control" id="descripcion" placeholder="escriba la descripcion del planeta">
    				</div>
  			</div>
  			<button type="submit" class="btn btn-primary">Guardar</button>
		</form>
</div>
 
</body>
</html>