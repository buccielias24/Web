
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
<link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


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
    <link href="css/grid.css" rel="stylesheet">
  
  	<!-- Filtro  -->
  </head>
  <body class="py-4">
    <div class="container">

  <h1>Listado de Planetas</h1>
  <p class="lead">Basic grid layouts to get you familiar with building within the Bootstrap grid system.</p>
  <p>In these examples the <code>.themed-grid-col</code> class is added to the columns to add some theming. This is not a class that is available in Bootstrap by default.</p>

  <h2 class="mt-4">Five grid tiers</h2>
  <p>There are five tiers to the Bootstrap grid system, one for each range of devices we support. Each tier starts at a minimum viewport size and automatically applies to the larger devices unless overridden.</p>
  
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nombre</th>
      <th scope="col">Ubicacion</th>
      <th scope="col">Estado</th>
    </tr>
  </thead>
  <tbody>
  	<% 
		try{	
			ArrayList<Planeta> planetas=new PlanetaControler().getAll();				
			for(Planeta p:planetas){
			%>
    <tr>
      <th scope="row"><%=p.getIdPlaneta()%></th>
      <td><%=p.getNombrePlaneta()%></td>
      <td><%=p.getCoordenada()%></td>
      <td class="estado" id="estado"><%=p.getEstado()%></td>
    </tr>    
  	<%
			}					
		}catch(Exception e) {}
%>
 </tbody>
</table>	


</div> <!-- /container -->

</body></html>