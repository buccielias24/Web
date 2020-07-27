<%@page import="entidades.Ciudadano"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<script type="text/javascript">
		$(document).on("submit", "#form", function(event) {
		    var $form = $(this);
		    $.post($form.attr("action"), $form.serialize(), function(response) {    	
		    	location.reload();	
		    });
		    event.preventDefault(); 	    
		});
</script>

<style type="text/css">
#inicioSesion{
	color: white;
}
</style>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul id="navItems" class="navbar-nav mr-auto">
      <li class="nav-item" id="home">
        <a class="nav-link" href="index2.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item" id="planets">
        <a class="nav-link" href="NewFile3.jsp">Planetas</a>
      </li>
      <li class="nav-item" id="travels">
        <a class="nav-link" href="Viajes.jsp">Viajes</a>
      </li>
    </ul> 
      <% 
           session.setAttribute("url", request.getRequestURL());
      		if(session.getAttribute("user")!=null)
      		{	
      		  Ciudadano c=(Ciudadano)session.getAttribute("user");	 
      %>  
    <ul class="navbar-nav ml-auto"> 
      <li class="nav-item dropdown ml-md-auto">
		<a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown"><%=c.getUser()%></a>
		 <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
		  <a class="dropdown-item" href="#">Perfil</a> <a class="dropdown-item" href="#">Proximos Viajes</a> <a class="dropdown-item" href="#">Viajes Realizados</a>
		 <div class="dropdown-divider">
		 </div> <a class="dropdown-item" href="/Web/logout">Salir</a>
		 </div>
	  </li>
	  <%}else {%>
	  <li class="nav-item  ml-md-auto">
		<a type="button" id="inicioSesion" class="btn btn-primary float-right" data-toggle="modal" data-target="#myModal">Iniciar Sesion</a>
	  </li>
	  <%}%>
    </ul>
  </div>
</nav>
<div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title" style="margin: auto;">Iniciar Sesion</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
      <div class="modal-body">
  	    <form class="form-signin" action="/Web/login" method="post" name="form" id="form" enctype="multipart/form-data">	
  		  <img class="mb-4" src="http://localhost:8080/Web/img/login.jpg" style="margin:auto;" alt="" width="200" height="200">
  		    <label for="inputEmail" class="sr-only">Email address</label>
 	        <input type="text" id="user" class="form-control" name="user" placeholder="Email address" required autofocus>
  	        <label for="inputPassword" class="sr-only">Password</label>
  	        <input type="password" id="password" class="form-control" name="password" placeholder="Password" required>
              <div class="checkbox mb-3">
    		   <label>
               <input type="checkbox" value="remember-me"> Remember me
              </label>
  			 </div>
  		 <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <div>
      		<a href="#">Olvide mi contraseña</a>
      		<a style="right: 0" href="#">Registrese aqui</a>
      </div>
      </form>			
    </div>
      </div>
    </div>
  </div>
</body>
</html>