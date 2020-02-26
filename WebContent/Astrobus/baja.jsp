<%@page import="logic.AstrobusController"%>
<%@page import="entidades.Astrobus"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<h3>Baja Astrobus</h3>
<br>
<br>
<form action="/Web/BajaAstrobus" method="post">
<%	AstrobusController ac=new AstrobusController();	
	Astrobus a=ac.getById((Astrobus)request.getAttribute("astrobus"));
%>
 <input type="text" id="inBaja1" name="inBaja1" value="<%=a.getIdNave()%>"><br>	
<% /* Fecha :<input type="datetime-local" id="inBaja2" name="inBaja2"><br>
Motivo: <textarea rows="10" cols="100" id="inBaja3" name="inBaja3"></textarea><br>*/ %>
 <input type="submit" value="aceptar">
</form>
</body>
</html>