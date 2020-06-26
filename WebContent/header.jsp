<%@page import="entidades.Ciudadano"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
 
<style type="text/css">
.dropbtn {
  background-color: #3498DB;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
  background-color: #2980B9;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  overflow: auto;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown a:hover {background-color: #ddd;}

.show {display: block;}
</style>

<script type="text/javascript">
		$(document).on("submit", "#form", function(event) {
		    var $form = $(this);
		    $.post($form.attr("action"), $form.serialize(), function(response) {    	
		    	location.reload();	
		    });
		    event.preventDefault(); 	    
		});
</script>

<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
</head>
<header>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <% 
    	if(session.getAttribute("user")==null)
    	{%>
    <a type="button" class="btn btn-primary float-right" data-toggle="modal" data-target="#myModal">Iniciar Sesion</a>
    	<% }else {
    		Ciudadano c=(Ciudadano)session.getAttribute("user");
    		session.setAttribute("url", request.getRequestURL());
    	%>
    	<div class="dropdown">
  			<button onclick="myFunction()" class="dropbtn"><%=c.getUser()%></button>
  			<div id="myDropdown" class="dropdown-content">
    		<a href="/UsuarioEdit">Editar</a>
    		<a href="#about">About</a>
    		<a href="/Web/logout">Logout</a>    
    		</div>
			</div>
    	<%} %>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
      </ul>
    </div>
  </nav>
</header>
<body>
<div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title" align="center">Iniciar Sesion</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
      <div class="modal-body">
  	    <form class="form-signin" action="/Web/login" method="post" name="form" id="form" enctype="multipart/form-data">	
  		  <img class="mb-4" src="http://localhost:8080/Web/img/login.jpg" alt="" width="200" height="200">
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
      </form>			
    </div>
      </div>
    </div>
  </div>
</body>
</html>