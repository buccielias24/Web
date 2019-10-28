<%@page import="entidades.Ciudadano"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1> Welcome <% Ciudadano c=new Ciudadano();	
	c=(Ciudadano)session.getAttribute("user");
	%> <%=c.getApellido()+", "+c.getNombre() %></h1>
</body>
</html>