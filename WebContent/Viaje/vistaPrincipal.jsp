<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="java.util.ArrayList"%>
<html lang="en"><head>
    <meta charset="utf-8">
    
    <title>Viajes</title>


    <!-- Bootstrap core CSS -->
<link href="/Web/css/bootstrap.min.css" rel="stylesheet">

<script src="/Web/js/popup-center.js"></script>
<style type="text/css">
.py-4{
margin-top: 50px;
}
</style>
  </head>
  
  <header>
  <jsp:include page="/header.jsp"></jsp:include>
</header>
  
  <body class="py-4">

<h1>Bienvenido</h1>
<h2> Por favor, seleccione el planeta para ver los viajes disponibles</h2>y
<form action="/Web/vistaViaje" method="get">
<select id="origen" name="origen" >
		<option disabled selected> -- select an option -- </option>
<% ArrayList<Planeta> planetas=new PlanetaControler().getAll();
		for(Planeta p:planetas)
		{%>
		<option value="<%=p.getIdPlaneta()%>"><%=p.getNombrePlaneta()%></option>				
		<%}%>
</select>
<select id="destino" name="destino" >
		<option disabled selected> -- select an option -- </option>
<% for(Planeta p:planetas)
		{%>
		<option value="<%=p.getIdPlaneta()%>"><%=p.getNombrePlaneta()%></option>				
		<%}%>
</select>
<input type="submit" value="Aceptar">
</form>
</body></html>

