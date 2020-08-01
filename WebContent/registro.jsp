<%@page import="entidades.Ciudadano"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>


<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<script type="text/javascript">
		$(document).on("submit", "#form", function(event) {
		    var $form = $(this);
		    $.post($form.attr("action"), $form.serialize(), function(response) {    	
		    alert(response.error);
		    },
		    dataType='json'
		    );
		    event.preventDefault(); 	    
		});

		</script>


</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			
			<form action="usuarioss"  id="form" method="post">	
  		  
  		    <label for="inputEmail" class="sr-only">Email address</label>
 	        <input type="text" id="user" class="form-control" name="user" placeholder="Email address" required autofocus>
  	        <label for="inputPassword" class="sr-only">Password</label>
  	        <input type="password" id="password" class="form-control" name="password" placeholder="Password" required>
              
  		 <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
		</div>
	</div>
</div>
</body>
</html>