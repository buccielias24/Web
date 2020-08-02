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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<script type="text/javascript">
		$(document).on("submit", "#form", function(event) {
		    var $form = $(this);
		    $.post($form.attr("action"), $form.serialize(), function(response) {    		  
		      if(response.error=="usuario_mail")
		    		{
		    		   $("#validationTooltip03").attr('class', 'form-control is-invalid');
		    		   $("#validationTooltip03_2").attr('class', 'invalid-feedback');
		    		   $("#validationTooltip03_2").append( "Correo no disponible");
		    		}else  
		    			{
		    			  if(response.estadoemail=="false")
		    			   {
		    				 $("#validationTooltip03").attr('class', 'form-control is-invalid');
		 		    		 $("#validationTooltip03_2").attr('class', 'invalid-feedback');
		 		    		 $("#validationTooltip03_2").append( "Correo invalido");  		
		    			   }	
		    					//$('#myModal').modal('show');
		    			}
		    },
		    dataType='json'
		    );
		    event.preventDefault(); 	    
		});

		</script>


</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			
			<form action="usuarios"  id="form" method="post">	  		  
			
  		      <div class="form-row">
  				  <div class="col-md-4 mb-3">
      <label for="validationServer01">First name</label>
      <input type="text" class="form-control is-invalid" id="validationServer01" placeholder="First name" value="Mark" required>
    </div>
    		      
    		      
                  <div class="col-md-4 mb-3">
      				 <label for="validationTooltip02">Apellido</label>
     				 <input type="text" class	="form-control" id="validationTooltip02" placeholder="Last name" value="Otto" required maxlength="20">
      				 	<div class="valid-tooltip">
       				    Looks good!
     	 				</div>
    			  </div>
    			  
    			  
    			 <div class="col-md-4 mb-3">
     				 <label for="validationTooltipUsername">Usuario</label>
      			 		<div class="input-group">
        		 			<div class="input-group-prepend">
          						<span class="input-group-text" id="validationTooltipUsernamePrepend">:</span>
        					</div>
        				  		<input type="text" class="form-control" id="validationTooltipUsername" placeholder="Username" aria-describedby="validationTooltipUsernamePrepend" required maxlength="10">
        					<div class="invalid-tooltip">
          						Please choose a unique and valid username.
        					</div>
      					</div>
    			</div>
  			 </div>
  			 
  			 
  		      <div class="form-row">
    		  	<div class="col-md-6 mb-3">
      				<label for="validationTooltip03">Email</label>
     				<input type="text" class="form-control" name="email" id="validationTooltip03" placeholder="City" required maxlength="50" onchange="this.val">
      			  <div id="validationTooltip03_2">
        			
      			  </div>
    	        </div>
    	        
    	        
    		   <div class="col-md-3 mb-3">
     			 	<label for="validationTooltip04">Contraseña</label>
      			 	<input type="text" class="form-control" id="validationTooltip04" placeholder="State" required maxlength="10">
      		     	<div class="invalid-tooltip">
        				Please provide a valid state.
      				</div>
    		   </div>
    		   
    		   
    		   <div class="col-md-3 mb-3">
      				<label for="validationTooltip05">Repetir Contraseña</label>
      				<input type="text" class="form-control" id="validationTooltip05" placeholder="Zip" required maxlength="10">
      				<div class="invalid-tooltip">
        				Please provide a valid zip.
      				</div>
    		   </div>
            </div>
            
            
  		<button class="btn btn-primary" type="submit">Submit form</button>
        
      </form>
      
    </div>
    
  </div>
  
</div>


<div class="modal" tabindex="-1" role="dialog" id="myModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Bienvenido!!!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick='location.href = "index.jsp";'>
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Gracias por registrate. Ha recibido un correo donde puede encontrar el codigo de autenticacion para validar su cuenta</p>
      </div>
    </div>
  </div>
</div>

</body>
</html>