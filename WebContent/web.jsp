<%@page import="logic.ControlAutobus"%>
<%@page import="entidades.Astrobus"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<html>
<body>
<h1> LISTADO DE PLANETAS </h1>

<table>

<tr>
	<th>ID</th><th>NOMBRE</th>
	<th>COORDENADA</th><th>ESTADO</th>
</tr>
<% 
	try{
		%> 
		<tr>
		<th>ID</th><th>NOMBRE</th>
		<th>COORDENADA</th><th>ESTADO</th>
		</tr>		
		<%
		ArrayList<Astrobus> buses=new ControlAutobus().getAll();
		
			for(Astrobus a:buses){
			%>
			<tr>
				<th>entro</th>
				<th><%=a.getMarca() %></th>	
				<th><% %></th>
				<th><% %></th>
				<th><% %></th>
			</tr><%
			} 
	}catch(Exception e) {}
%>
</table>
</body>
</html>