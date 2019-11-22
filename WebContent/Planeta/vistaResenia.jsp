<%@page import="entidades.Ciudadano"%>
<%@page import="logic.UserController"%>
<%@page import="entidades.Planeta"%>
<%@page import="entidades.Resenia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.reseniaController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resenias</title>
</head>
<body>
<table>
<tr>
	<th>ID</th><th>NOMBRE</th>
	<th>COORDENADA</th><th>ESTADO</th>
</tr>
		<% reseniaController rc=new reseniaController();
			ArrayList<Resenia> resenias=rc.getAll((Planeta)request.getAttribute("planeta"));				
				for(Resenia res:resenias)
				{
				%>
				<tr>
					<th><%=res.getDgu()%></th>
					<th><%=res.getComentario()%></th>
					<%}%>
				</tr>	
</table>											
</body>
</html>