<%@page import="java.time.LocalDate"%>
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
<form action="/Web/CargaViaje" method="post">
		<h3>Seleccione Origen</h3>
<select required type="text" id="elegirOrigen" onchange="seleccion(this.value)" name="origen">
		<option disabled selected> -- select an option -- </option>
<% 		ArrayList<Planeta> planetas=(ArrayList<Planeta>)request.getAttribute("planetasDisponibles");
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
<label for="start">Hora de Salida:</label>

<input type="time" id="start" name="horaSalida"
       value="00:00"
       min="00:00" max="23:59">
<br><br>
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
<br>
<h3>Que dias realizara los viajes</h3>
<input type="checkbox" name="Lunes" value="true">Lunes<br>
<input type="checkbox" name="Martes" value="true">Martes<br>
<input type="checkbox" name="Miercoles" value="true">Miercoles<br>
<input type="checkbox" name="Jueves" value="true">Jueves<br>
<input type="checkbox" name="Viernes" value="true">Viernes<br>
<input type="checkbox" name="Sabado" value="true">Sabado<br>
<input type="checkbox" name="Domingo" value="true">Domingo<br>

<br>
<h3>Durante cuanto tiempo se realizara este viaje</h3>
<%LocalDate today=LocalDate.now(); %>
<input type="date" id="desde" name="desde" value="" min="<%=today%>" max="2020-12-31">
<input type="date" id="hasta" name="hasta" value="" min="<%=today%>" max="2020-12-31">
<br>
<input type="submit" value="Aceptar">
</form>
</body>
</html>