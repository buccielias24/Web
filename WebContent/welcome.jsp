<%@page import="entidades.Ciudadano"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<meta http-equiv="Refresh" content="2 ; url=index.jsp"/>
</head>
<body>
	<h1> Welcome <% Ciudadano c=new Ciudadano();	
	c=(Ciudadano)session.getAttribute("user");
	%> <%=c.getUser()%></h1>
	
</body>
</html>