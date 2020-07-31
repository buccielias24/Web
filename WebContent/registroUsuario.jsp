<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Raza"%>
<%@page import="logic.RazaController"%>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>User Register</title>

    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    	<link href="css/form-validation.css" rel="stylesheet">
    	
    	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

        <script src="js/pass-validation.js"> 
        </script>
        
        <script type="text/javascript">
		$(document).on("submit", "#form", function(event) {
		    var $form = $(this);
		    $.post($form.attr("action"), $form.serialize(), function(response) {    	
		    	alert(response);
		    });
		    event.preventDefault(); 	    
		});
</script>

  </head>
  <body class="bg-light">
    <div class="container">
  <div class="py-5 text-center">
    <h2>Registro de Usuarios</h2>
    <p class="lead">Below is an example form built entirely with Bootstrap’s form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>

    <div class="py-5 text-center">
  
      <h4 class="mb-3">Complete los datos</h4>
      <form class="needs-validation" action="/usuarios" method="post" name="form" id="form" enctype="multipart/form-data">
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="name">First name</label>
            <input type="text" class="form-control" id="firstName" name="nombre" placeholder="" value="" required>
            <div class="invalid-feedback">
              Valid first name is required.
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="lastName">Last name</label>
            <input type="text" class="form-control" name="apellido" id="lastName" placeholder="" value="" required>
            <div class="invalid-feedback">
              Valid last name is required.
            </div>
          </div>
        </div>

		
        <div class="mb-3">
          <label for="username">Username</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">@</span>
            </div>
            <input type="text" class="form-control" id="username" name="usuario" placeholder="Username" required>
            <div class="invalid-feedback" style="width: 100%;">
              Your username is required.
            </div>
          </div>
        </div>

      
         
     
      <div class="mb-3">
          <label for="pass1">Password <span class="text-muted"></span></label>
          <input type="password" class="form-control" id="password" name="password" placeholder="password" required>
          <div class="invalid-feedback">
            Please enter a valid password.
          </div>
        </div>
        
         <div class="mb-3">
          <label for="pass2">Repeat Password </label>
          <input type="password" class="form-control" id="password2" name="password2" placeholder="password" required>
          <div class="invalid-feedback">
          </div> <span id="error2"></span>
        </div>  
        
        	  <div class="mb-3">
          <label for="email">Email <span class="text-muted"></span></label>
          <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>
          <div class="invalid-feedback">
            Please enter a valid email address.
          </div>
        </div>
		
        
          <div class="row">
          <div class="col-md-5 mb-3">
            <label for="country">Planeta</label>
            <select class="custom-select d-block w-100" id="planeta" name="planeta" required>
              <option value="">Choose...</option>
              <option>Earth</option>
            </select>
            <div class="invalid-feedback">
              Please select a valid planet.
            </div>
          </div>
            <div class="col-md-4 mb-3">
            <label for="state">Raza</label>
            <select class="custom-select d-block w-100" id="raza" name="raza" required>
              <option disabled value="">Choose...</option>
              <% 
              RazaController rc=new RazaController(); 
            	 for(Raza r:rc.getAll())
            	  {
            	  %>
              <option value="<%=r.getIdRaza()%>"><%=r.getNombre()%></option>
           			<%}%> 
            </select>
            <div class="invalid-feedback">
              Please provide a valid state.
            </div>
          </div>
          
          <div class="col-md-3 mb-3">
            <label for="zip">DGU</label>
            <input type="text" class="form-control" id="DGU" name="dgu" placeholder="" required>
            <div class="invalid-feedback">
              DGU code required.
            </div>
          </div>
         <input type="hidden" value="nuevo" name="action">
        </div>
         <label><input id="chknotificacion" type="checkbox"> Deseo recibir notificaciones acerca de nuevos viajes</label>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
      </form>
    </div>
  </div>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">© 2017-2019 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
      <script>window.jQuery || document.write('<script src="js/jquery-slim.min.js"><\/script>')</script><script src="js/bootstrap.bundle.min.js" ></script>   
        <script src="js/form-validation.js"></script>
</body></html>