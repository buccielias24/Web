<%@page import="entidades.Viaje"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
			<h3>Viajes no agregados por falta de astrobuses</h3>
		<%
			ArrayList<Viaje> viajes=(ArrayList<Viaje>)request.getAttribute("sinAsignar");
			for(Viaje v:viajes)
			{%>
				<p>Origen: <%=v.getOrigen()%>, destino: <%=v.getOrigen()%></p><br>		
			<%}
		%>
</body>
</html>