
<%@page import="logic.reseniaController"%>
<%@page import="entidades.Resenia"%>
<%@page import="entidades.Ciudadano"%>
<%@page import="entidades.Planeta"%>
<%@page import="logic.PlanetaControler"%>
<%@page import="java.util.ArrayList"%>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Listado de Planetas</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/grid/">

    <!-- Bootstrap core CSS -->
<link href="/Web/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="/Web/js/filtrar.js"></script>  <!-- Filtro Planetas -->
<script src="/Web/js/popup-center.js"></script>	 <!-- Ventana emergente -->
    <style>
    
    .checked {
  color: orange;
}
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
    
    <!-- LLAMAR AL CERRAR SESION  -->
    <form action="/Web/logout" method="post">
    <input id="logout" type="submit" value="logout"/> 
    </form>
    
  <h1>Listado de Planetas</h1>
 <% 
 	Ciudadano c=null;
 if((Ciudadano)session.getAttribute("user")==null)
 {
 }else {c=(Ciudadano)session.getAttribute("user");}
    	if (c!=null && c.getRol()==1)
    		{%>
	    		<p class="lead">Desde aqui podra realizar la alta baja o modificacion de los planetas.</p>
    		<p><a class="btn btn-secondary" onclick="popupWindow('/Web/Planeta/registrarPlaneta.jsp', 'test', window, 500, 250)" role="button">Nuevo Planeta</a></p>	
<%}%>
<input type="text" id="myInput" onkeyup="filtrar()" placeholder="Search Planets..">

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nombre</th>
      <th scope="col">Ubicacion</th>
      <th scope="col">Estado</th>
      <th scope="col">Puntaje</th> 
      <th scope="col">Cant Votos</th>
    </tr>
  </thead>
  <tbody id="myTbody">
  	<% 
		try{	
			ArrayList<Planeta> planetas=new PlanetaControler().getAll();				
			for(Planeta p:planetas){
			%>
    <tr>
      <th scope="row"><%=p.getIdPlaneta()%></th>
      <td><%=p.getNombrePlaneta()%></td>
      <td><%=p.getCoordenada()%></td>
      <% String r=null;
      	if(p.getEstado()==true){r="Disponible";}else{r="No disponible";}
      %>
      <td><%=r %></td>
      <td>
      <%reseniaController rc=new reseniaController(); %>
	<% for(int i=0;i<Math.round(rc.getPuntaje(p));i++){ %>    
      <span class="fa fa-star checked"></span><%}
      
    	  for(int j=0;j<5-Math.round(rc.getPuntaje(p));j++)
    		  	{%>     
					<span class="fa fa-star"></span><%}%>
    	  					
      </td>
     <th><a href="/Web/resenia?id=<%=p.getIdPlaneta()%>&accion=view"><%=rc.getAll(p).size()%></a></th>  
     <% 
     	if(c!=null && c.getRol()==1)
     	{
     %>	
     <th><a class="btn btn-secondary" onclick="popupWindow('/Web/Modificar?id=<%=p.getIdPlaneta()%>', 'test', window, 500, 250)">Modificar</a></th>
     <th><a class="btn btn-secondary" onclick="popupWindow('/Web/BajaPlaneta?id=<%=p.getIdPlaneta()%>', 'test', window, 500, 250)">Dar de Baja</a></th>
         
    </tr>   
  	<%} 
  	  	
			}					
		}catch(Exception e) {}
%>
 </tbody>
</table>	


</div> <!-- /container -->

</body></html>