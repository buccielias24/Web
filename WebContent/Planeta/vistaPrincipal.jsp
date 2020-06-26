<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Planetas</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/grid/">

    <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-2.1.4.min.js" integrity="sha384-R4/ztc4ZlRqWjqIuvf6RX5yb/v90qNGx6fS48N0tRxiGkqveZETq72KgDVJCp2TC"crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
   
    <!-- Custom styles for this template -->
    <link href="/Web/css/grid.css" rel="stylesheet">
	<style>
		.checked {
  		color: orange;	
		}
	</style>

  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="/Web/js/viewPlanets.js"></script>
  
    
<script type="text/javascript">
		$(document).on("submit", "#form", function(event) {
		    var $form = $(this);
		    $.post($form.attr("action"), $form.serialize(), function(response) {    	
		    	$("#tablebody").empty();
		    	response.pop();
		    	 $.each( response, function( key, val ) {	
	        		  tr = $('<tr class="text-center"/>');
	        		  tr.append('<td style="display:none;">' + val.id_planeta + "</td>"); 
	        		  tr.append("<td>" + val.nombre + "</td>");  
	                  tr.append("<td>" + val.coordenadaX + "</td>"); 
                      tr.append("<td>" + val.coordenadaY + "</td>");
                      tr.append("<td>" + val.estado + "</td>");
			          var estrellas='';
                      var total=0;
                      var i=0;
                      for (i in val.resenias) {
                     	   total++;                         
                        }
			          for(var j=0; j<5;j++)
          	      	  {
                	   if(val.puntaje>j)
                		{
                		   estrellas=estrellas+('<span class="fa fa-star checked"></span>');    	      
                		}else{
                		   estrellas=estrellas+('<span class="fa fa-star"></span>');	
                		}   
                	  }
                      tr.append("<td>" + estrellas + "</td>"); 
                      tr.append("<td><a onclick='completeComment("+JSON.stringify(val.resenias)+")'>"+total+"</a></td>");                      	
                      tr.append("<td>" + '<button type="button" id="trigger_modal" class="btn btn-primary" data-toggle="modal" data-target="#myModal2">Editar</button>' + '<button style="margin-left: 10px;" type="button"  id="trigger_modal" class="btn btn-danger" data-toggle="modal" data-target="#myModalDelete">Eliminar</button>'  +"</td>");
                      $('#tablebody').append(tr);
		    	 	});
		    	 	alert("Planeta actualizado");
		    });
		    event.preventDefault(); 	    
		});
</script>


<script>
$(document).ready(function(){
	  $(".thehide").hide();
	  $(document).on("click", "table button", function(){
	    $("#myModal2 .modal-body").html($("#partial_container").html());
	    $('#myModal2 input[name="id"]').val($(this).closest("tr").find("td:nth-child(1)").text());
	    $('#myModal2 input[name="nombre"]').val($(this).closest("tr").find("td:nth-child(2)").text());
	    $('#myModal2 input[name="coordenadaX"]').val($(this).closest("tr").find("td:nth-child(3)").text());
	    $('#myModal2 input[name="coordenadaY"]').val($(this).closest("tr").find("td:nth-child(4)").text());
	    $('#myModal2 input[name="estado"]').val($(this).closest("tr").find("td:nth-child(52 )").text());
	  });	  
});	
</script>

<script>
$(document).ready(function(){
	  $(document).on("click", "table button", function(){
	    $('#myModalDelete input[name="id"]').val($(this).closest("tr").find("td:nth-child(1)").text());
	    $('#myModalDelete input[name="nombre"]').val($(this).closest("tr").find("td:nth-child(2)").text());
	  });	  
});
</script>

<script>
function completeComment(resenias){
 $('#userCom').empty();
 $.each( resenias, function( key, val ) {
 $('#myModalResenias').modal('show');	
 var body=$('#userCom');
 var estrellas='';
   for(i=0; i<val.puntaje;i++){
	 estrellas=estrellas+'<i class="text-warning fa fa-star"></i>';}
	   	
   	 body.append('<div class="card"><div class="card-body"><div class="row"><div class="col-md-2">'+
	  '<img src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid"/>'+
	   '<p class="text-secondary text-center">'+val.fecha+'</p></div>'+
	    '<div class="col-md-10"><p>'+
	     '<a class="float-left" href="https://maniruzzaman-akash.blogspot.com/p/contact.html"><strong>'+val.apelnom+'</strong></a>'+
	      '<span class="float-right">'+estrellas+'</span> </p>'+
	       '<div class="clearfix"></div><p id="comment">'+val.comentario+'</p>'+      
	        '<a class="float-right btn btn-outline-primary ml-2"> <i class="fa fa-reply"></i> Edit</a>'+
	       	 '<p>'+'<a class="float-right btn btn-outline-primary ml-2"> <i class="fa fa-reply"></i> Reply</a>'+
	       	  '<a class="float-right btn text-white btn-danger"> <i class="fa fa-heart"></i> Like</a>'+
	       	   '</p></div></div> </div></div>');
	});
}
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
                            <th>Coordenada X</th>
                            <th>Coordenada Y</th>
                            <th>Estado</th>
                            <th>Puntaje</th>
                    		<th>Total</th>
                        </tr>
                    </thead>
                    <tbody id="tablebody">  
                    	
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- MODAL Resenias -->
  <div class="modal" id="myModalResenias">
    <div class="modal-dialog modal-xl">
     <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="text-center">Comentarios</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
  	    <div class="modal-body">
  			<div id="userCom" class="container">
  				<h2 class="text-center">Comentarios</h2>
					
		<p><a class="btn btn-secondary"  role="button">Comentario</a></p>
</div>	
  		</div>
   
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
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
  <form id="form" name="form" action="/Web/Planetas" method="post">
     <input type="hidden" value="edit" name="accion">
			 <div class="form-group row">
    		    <label for="inputNombre" class="col-sm-2 col-form-label">ID</label>
   					<div class="col-sm-10">
   						<input type="text" class="form-control" id="ID" name="id" readonly>
    				</div>
  			</div>
  			<div class="form-group row">
  			   <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
    				<div class="col-sm-10">
     					<input type="text" class="form-control" id="inputNombre" name="nombre" placeholder="Coordenada X">
    				</div>
  			</div>
  			<div class="form-group row">
  			   <label for="inputCoordenadaX" class="col-sm-2 col-form-label">Pos X</label>
    				<div class="col-sm-10">
     					<input type="text" class="form-control" id="inputCoordenadaX" name="coordenadaX" placeholder="Coordenada X">
    				</div>
  			</div>
  				<div class="form-group row">
  			   <label for="inputCoordenadaY" class="col-sm-2 col-form-label">Pos Y</label>
    				<div class="col-sm-10">
     					<input type="text" class="form-control" id="inputCoordenadaY" name="coordenadaY" placeholder="Coordenada Y">
    				</div>
  			</div>
  			<div class="form-group row">
  			   <label for="estado" class="col-sm-2 col-form-label">Estado</label>
    				<div class="col-sm-10">
     					<input type="text" class="form-control" id="inputEstado" name="estado" placeholder="Estado">
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

<!-- MODAL ELIMINAR PLANETA -->
  <div class="modal" id="myModalDelete">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title" align="center">Eliminar</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
  		<form action="/Web/Planetas" method="post" name="form" id="form" enctype="multipart/form-data">
			 <input type="hidden" value="delete" name="accion">
			 <div class="form-group row">
    		    <label for="inputNombre" class="col-sm-2 col-form-label">ID</label>
   					<div class="col-sm-10">
   						<input type="text" class="form-control" id="ID" name="id" readonly>
    				</div>
  			</div>
			 <div class="form-group row">
    		    <label for="inputNombre" class="col-sm-2 col-form-label">Nombre</label>
   					<div class="col-sm-10">
   						<input type="text" class="form-control" id="inputNombre" name="nombre" placeholder="Nombre Planeta" readonly>
    				</div>
  			</div>			
  			<button type="submit" class="btn btn-danger">Eliminar</button>
		</form>			
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
 
</body>
</html>