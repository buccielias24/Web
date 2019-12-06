
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
      <th scope="col">Marca</th>
      <th scope="col">Asientos</th>
       <th scope="col">Distancia Limite</th>
        <th scope="col">Tiempo sin uso</th>
         <th scope="col">Distancia recorrida</th>
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
    </tr>    
  	<%
  	  	
			}					
		}catch(Exception e) {}
%>
 </tbody>
</table>	


</div> <!-- /container -->

</body></html>