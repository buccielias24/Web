<%@page import="entidades.Planeta"%>
<%@page import="logic.PlanetaControler"%>
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
</body>
</html>