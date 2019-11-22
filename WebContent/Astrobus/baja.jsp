<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Baja Astrobus</title>
</head>
<body>

<h1>BAJA DE PLANETAS</h1>
<h2> LISTADO DE PLANETAS</h2>
<table>
<tr>
	<th>ID</th><th>NOMBRE</th>
	<th>COORDENADA</th><th>ESTADO</th>
</tr>
<% 
	try{	
		ArrayList<Planeta> planetas=new PlanetaControler().getAll();
					
			for(Planeta p:planetas){
			%>
			<tr>
				<th><%=p.getIdPlaneta()%></th>	
				<th><%=p.getNombrePlaneta()%></th>
				<th><%=p.getCoordenada()%></th>
				<th><%=p.getEstado()%></th>
			</tr><%
			} 
	}catch(Exception e) {}
%>
</table>
<br>
<br>
<form action="/Web/Planetas" method="post">
  <label>ID Planeta</label> <input type="text" name="id">
  							<input type="hidden" name="accion" value="baja">
  <input type="submit" value="Aceptar">
</form>

</body>
</html>