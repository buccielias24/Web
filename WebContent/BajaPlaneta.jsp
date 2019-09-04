<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="java.util.ArrayList"%>
<html>
<body>
<h1>Modificar Planeta</h1>
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
<br>
<br>
<form action="BajaPlaneta" method="post">
  ID: <input type="text" name="id"><br>
  <input type="submit" value="Seleccionar">
</form>
</body>
</html>