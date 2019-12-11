
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
    <title>Viajes</title>

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

  <h1>Gestion de Viajes</h1>
  <p class="lead">Desde aqui podra realizar la alta baja o modificacion de los viajes.</p>
 	<p><a class="btn btn-secondary" onclick="popupWindow('/Web/Viaje/registrarViaje.jsp', 'test', window, 600, 300)" role="button">Nuevo Viaje</a></p>	
<!--  <input type="text" id="myInput" onkeyup="filtrar()" placeholder="Search Planets.."> -->

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Origen</th>
      <th scope="col">Destino</th>
       <th scope="col">Fecha y Hora Salida</th>
        <th scope="col">Fecha Y Hora Llegada</th>
         <th scope="col">Estado</th>
   		      <th scope="col">Distancia</th> 	
    </tr>
  </thead>
  <tbody id="myTbody">
  	<% 
		try{	
			Planeta p=new Planeta();
			
			PlanetaControler pc=new PlanetaControler();
			
			ArrayList<Viaje> viajes=new ViajeController().getAll();				
			for(Viaje v:viajes){
			
			%>
    <tr>
      <th scope="row"><%=v.getIdViaje()%></th>
      <td><%=pc.getById(v.getOrigen()).getNombrePlaneta()%></td>  <!-- Muestra el objeto entero Planeta ver para arreglar la vista -->
      <td><%=pc.getById(v.getDestino()).getNombrePlaneta()%></td>
      <td><%=v.getSalida()%></td>
      <td><%=v.getLlegada()%></td>
      <td><%=v.getEstado()%></td>
      <td><%=v.getDistancia()%></td>
	</tr>    
  	<%
  	  	
			}					
		}catch(Exception e) {}
%>
 </tbody>
</table>	


</div> <!-- /container -->

</body></html>