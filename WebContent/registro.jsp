<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Registro</title>


<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<script type="text/javascript">
		$(document).on("submit", "#form", function(event) {
		    //limpia mensajes inputs invalidos
		    
			$("#validationTooltipUsername").attr('class', 'form-control');
		    $("#validationTooltipUsername2").attr('class', '');
		    $("#validationTooltipUsername2").empty();
		    
		    $("#validationTooltip03").attr('class', 'form-control');
		    $("#validationTooltip03_2").attr('class', '');
		    $("#validationTooltip03_2").empty();
		    
		    $("#validationTooltip05").attr('class', 'form-control');
		    $("#validationTooltip05_2").attr('class', '');
		    $("#validationTooltip05_2").empty();
		    
		    
			var $form = $(this);
		    $.post($form.attr("action"), $form.serialize(), function(response) {    
		    	if(response.error=="bad_pass")
		    	  {
		    	  $("#validationTooltip05").attr('class', 'form-control is-invalid');
	    		   $("#validationTooltip05_2").attr('class', 'invalid-feedback');
	    		   $("#validationTooltip05_2").append("Las contraseñas no coinciden");
		    	  }else
		    	 	{	
		    	
		    	if(response.error=="sintaxisUsuario")
		    	  {
		    	  $("#validationTooltipUsername").attr('class', 'form-control is-invalid');
	    		   $("#validationTooltipUsername2").attr('class', 'invalid-feedback');
	    		   $("#validationTooltipUsername2").append("Lo sentimos, solo se permiten letras (a-z), números (0-9)");
		    	  }else
		    	 	{
		      if(response.error=="userexist")
		    	  {
		    	  $("#validationTooltipUsername").attr('class', 'form-control is-invalid');
	    		   $("#validationTooltipUsername2").attr('class', 'invalid-feedback');
	    		   $("#validationTooltipUsername2").append("Usuario ya existe");
		    	  }else
		    	 	{
		    		  if(response.error=="usuario_mail")
			    		{
			    		   $("#validationTooltip03").attr('class', 'form-control is-invalid');
			    		   $("#validationTooltip03_2").attr('class', 'invalid-feedback');
			    		   $("#validationTooltip03_2").append( "Correo no disponible");
			    		}else  
			    			{
			    			  if(response.error=="false")
			    			   {
			    				 $("#validationTooltip03").attr('class', 'form-control is-invalid');
			 		    		 $("#validationTooltip03_2").attr('class', 'invalid-feedback');
			 		    		 $("#validationTooltip03_2").append( "Correo invalido");  		
			    			   }else
			    				   {
			    				   	$('#myModal').modal('show');
			    				   }		    					
			    			}
		    	   	}
		         }
		      }
		    },
		    dataType='json'
		    );
		    event.preventDefault(); 	    
		});

		</script>

<style type="text/css">
.card {
	margin: auto;
}

html, body {
    height: 100%;
}

/* CSS only for examples not required for centering */
.container {
    height: 100%;
}

</style>
</head>
<body>
	<div class="container">
		<div class="row h-100">
			<div class="col-sm-12 align-self-center">
				<div class="card w-75 card-block">
				  <h5>Crear Cuenta </h5>
					<form action="usuarios" id="form" method="post" autocomplete="off">
						<div class="form-row">
							<div class="col-md-4 mb-3">
								<label for="validationServer01">Primer Nombre</label> <input
									type="text" class="form-control"
									id="validationServer01" name="nombre" placeholder="Nombre" value="" maxlength="20"
									required>
							</div>


							<div class="col-md-4 mb-3">
								<label for="validationTooltip02">Apellido</label> <input
									type="text" class="form-control" id="validationTooltip02"
									placeholder="apellido" value="" required maxlength="20">
							</div>


							<div class="col-md-4 mb-3">
								<label for="validationTooltipUsername">Usuario</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"
											id="validationTooltipUsernamePrepend"></span>
									</div>
									<input type="text" class="form-control"
										id="validationTooltipUsername"  name="usuario" placeholder="Usuario"
										aria-describedby="validationTooltipUsernamePrepend" required
										maxlength="10">
									<div id="validationTooltipUsername2"></div>
								</div>
							</div>
						</div>


						<div class="form-row">
							<div class="col-md-6 mb-3">
								<label for="validationTooltip03">Email</label> <input
									type="email" class="form-control" name="email"
									id="validationTooltip03" placeholder="Email" required
									maxlength="50" onchange="">
								<div id="validationTooltip03_2"></div>
							</div>


							<div class="col-md-3 mb-3">
								<label for="validationTooltip04">Contraseña</label> <input
									type="password" class="form-control" id="validationTooltip04" name="password"
									placeholder="Contraseña" required maxlength="10">
							</div>


							<div class="col-md-3 mb-3">
								<label for="validationTooltip05">Repetir Contraseña</label> <input
									type="password" class="form-control" id="validationTooltip05" name="password2"
									placeholder="Repetir Contraseña" required maxlength="10">
									<div id="validationTooltip05_2"></div>
						</div>
					  </div>

						<button class="btn btn-primary" type="submit">Submit form</button>

					</form>

				</div>

			</div>
		</div>
	</div>


	<div class="modal" tabindex="-1" role="dialog" id="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Bienvenido!!!</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" onclick='location.href = "index.jsp";'>
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Gracias por registrate. Ha recibido un correo donde puede
						encontrar el codigo de autenticacion para validar su cuenta</p>
				</div>
			</div>
		</div>
	</div>

</body>
</html>