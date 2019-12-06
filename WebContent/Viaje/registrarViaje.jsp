<%@page import="logic.AstrobusController"%>
<%@page import="entidades.Astrobus"%>
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
<form action="/Web/CargaViaje" method="get">
		<h3>Seleccione Origen</h3>
<select required type="text" id="elegirOrigen" onchange="seleccion(this.value)" name="origen">
		<option disabled selected> -- select an option -- </option>
<% ArrayList<Planeta> planetas=new PlanetaControler().getAll();
		for(Planeta p:planetas)
		{%>
		<option id="lala" value="<%=p.getIdPlaneta()%>"><%=p.getNombrePlaneta()%></option>				
		<%}%>
</select>


	<script>
	function seleccion(value)
	{
		var select=document.getElementById("elegirDestino");
 
		// Cogemos el listado de opciones en un array de valores
		var op=select.getElementsByTagName("option")
 
		// Seleccionamos la primera opción
		select.options[0].selected=true;
 
		// Recorremos todas las opciones del segundo select
		for (var i = 1; i < op.length; i++) {
 
			if(op[i].value == value)
			{
				// Si coincide, lo desmarcamos o escondemos 
				//(selecciona una de las dos opciones) 
				//op[i].disabled = true;
				op[i].style.display="none";
			}else{
				// Si no coincide, lo marcamos o mostramos
 
				//(selecciona una de las dos opciones)
 
// 				op[i].disabled = false;
				op[i].style.display="block";
			}
		}
	}
	</script>
	
		<h3>Seleccione Destino</h3>
<select id="elegirDestino" name="destino">
		<option disabled selected> -- select an option -- </option>
<% 	for(Planeta p:planetas)
		{%>
		<option value="<%=p.getIdPlaneta()%>"><%=p.getNombrePlaneta()%></option>				
		<%}%>
</select> <br><br>
<label for="start">Fecha de Salida:</label>

<input type="datetime-local" id="start" name="fechaSalida"
       value="2019-09-17"
       min="2019-01-01" max="2020-12-31">
<br><br>
<label for="start">Fecha de Llegada:</label>
<input type="datetime-local" id="finish" name="fechaLlegada" 
       value="2019-09-17"
       min="2019-01-01" max="2020-12-31">
 <br><br>      
 <h3>Astrobus definido para el viaje</h3>
<select required type="text" id="elegirAstrobus"  name="elegirAstrobus">
		<option disabled selected> -- select an option -- </option>
<% 
		AstrobusController ac=new AstrobusController();
		ArrayList<Astrobus> astrobuses=ac.getAll();
		for(Astrobus a:astrobuses)
		{%>
		<option id="lala" value="<%=a.getIdNave()%>"><%=a.getMarca()%></option>				
		<%}%>
</select>
<br><br><br>


<input type="submit" value="Aceptar">
</form>
</body>
</html>