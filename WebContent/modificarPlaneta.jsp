<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="java.util.ArrayList"%>
<html>
<body>
<h1>MODIFICAR PLANETA</h1>
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
<form action="Modificar" method="post">
  <label>ID Planeta</label> <input type="text" name="id">
  <input type="submit" value="Aceptar">
</form>
</body>
</html>