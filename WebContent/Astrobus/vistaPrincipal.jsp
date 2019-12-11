
<%@page import="entidades.Ciudadano"%>
<%@page import="entidades.Astrobus"%>
<%@page import="logic.AstrobusController"%>
<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="logic.ViajeController"%>
<%@page import="entidades.Viaje"%>
<%@page import="java.util.ArrayList"%>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Naves</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/grid/">

    <!-- Bootstrap core CSS -->
<link href="/Web/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">	
<script src="/Web/js/popup-center.js"></script>
    <style>
    .linea
{
    display: inline-block;
}
    
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
    <link href="/Web/css/grid.css" rel="stylesheet">
  </head>
  
  <header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <% if(session.getAttribute("user")==null)
    	{%>
    <a class="navbar-brand" href="/Web/login.jsp">Login</a>
    	<% }else {%>
    <a class="navbar-brand" href="logout">Logout</a>    
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
        </li>
        <li class="nav-item">
       <% try{ 
    	Ciudadano c=new Ciudadano();	
		c=(Ciudadano)session.getAttribute("user");
	    %> 
          <a class="nav-link disabled" href="#"><%=c.getUser()%></a><%}catch(Exception e){ %>
          <a class="nav-link disabled" href="#">-</a><%}%>
        </li>
      </ul>
      <form class="form-inline mt-2 mt-md-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
</header>

  <body class="py-4">
    <div class="container">

  <p class="lead">Astrobuses</p>
 	<p><a class="btn btn-secondary" onclick="popupWindow('/Web/Viaje/registrarViaje.jsp', 'test', window, 600, 300)" role="button">Nuevo Viaje</a></p>	
<!--  <input type="text" id="myInput" onkeyup="filtrar()" placeholder="Search Planets.."> -->

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Marca</th>
      <th scope="col">Asientos</th>
       <th scope="col">Distancia Limite</th>
       <th scope="col">Tiempo sin uso</th>
       <th scope="col">Distancia recorrida</th>
       <th scope="col">Estado</th>
       <th scope="col">Fecha Alta</th>
       <th scope="col">Fecha Baja</th>
       <th scope="col">Motivo</th>
       <th scope="col">Comentario</th>    
    </tr>
  </thead>
  <tbody id="myTbody">
  	<% 
		try{	
			Astrobus a=new Astrobus();
			
			AstrobusController ac=new AstrobusController();
			
			ArrayList<Astrobus> astrobuses=new AstrobusController().getAll();				
			for(Astrobus astro:astrobuses){
			
			%>
    <tr>
      <th scope="row"><%=astro.getIdNave()%></th>
      <td><%=astro.getMarca() %></td>
      <td><%=astro.getCantAsientos() %></td>
      <td><%=astro.getDistLimite() %></td>
      <td><%=astro.getTiempoLibre() %></td>   
      <td><%=ac.getDistancia(astro)%></td>        
      <td><%=astro.getEstado()%></td>  
   	  <td><%=astro.getFecha_alta()%></td>
   	  <td><%=astro.getFecha_baja()%></td>
   	  <td><%=astro.getMotivo()%></td>
   	  <td><%=astro.getComentario()%></td>	
    </tr>    
  	<%
  	  	
			}					
		}catch(Exception e) {}
%>
 </tbody>
</table>	


</div> <!-- /container -->

</body></html>