<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Viaje</title>
</head>
<body>
<form action="CargaViaje" method="get">
		<h3>Seleccione Origen</h3>
<select id="elegirOrigen"  name="origen">
<% ArrayList<Planeta> planetas=new PlanetaControler().getAll();
		for(Planeta p:planetas)
		{%>
		<option value="<%=p.getIdPlaneta()%>"><%=p.getNombrePlaneta()%></option>				
		<%}%>
</select>
		<h3>Seleccione Destino</h3>
<select id="elegirDestino"  name="destino">
<% 	for(Planeta p:planetas)
		{%>
		<option value="<%=p.getIdPlaneta()%>"><%=p.getNombrePlaneta()%></option>				
		<%}%>
</select> <br><br>
<label for="start">Fecha de Salida:</label>
<input type="date" id="start" name="fechaSalida"
       value="2019-09-17"
       min="2019-01-01" max="2020-12-31">
<br><br>
<label for="start">Fecha de Llegada:</label>
<input type="date" id="start" name="fechaLlegada"
       value="2019-09-17"
       min="2019-01-01" max="2020-12-31">
 <br><br><br>      
<input type="submit" value="Aceptar">
</form>
</body>
</html>