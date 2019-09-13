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
		if (request.getAttribute("a")==null){
			ArrayList<Planeta> planetas=new PlanetaControler().getAll();				
			for(Planeta p:planetas){
			%>
			<tr>
				<th><%=p.getIdPlaneta()%></th>	
				<th><%=p.getNombrePlaneta()%></th>
				<th><%=p.getCoordenada()%></th>
				<th><%=p.getEstado()%></th>
			</tr>
			<%
			}%>
			<form action="Modificar" method="post">
  			<label>ID Planeta</label> <input type="text" name="id">
  			<label>Nombre</label> <input type="text" name="nombre">
  			<label>Coordenada</label> <input type="text" name="coordenada">
  			<input type="submit" value="Aceptar">
			</form>
			<%			
		}else {
			int id=(Integer)request.getAttribute("a");
			ArrayList<Planeta> planetas=new PlanetaControler().getById(id);				
			for(Planeta p:planetas){
			%>
			<tr>
				<th><%=p.getIdPlaneta()%></th>	
				<th><%=p.getNombrePlaneta()%></th>
				<th><%=p.getCoordenada()%></th>
				<th><%=p.getEstado()%></th>
			</tr>
			<%
			}
		}}catch(Exception e) {}
%>
</table>
</body>
</html>