<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="java.util.ArrayList"%>
<html>
<body>
<h1>Modificar</h1>
<table>
<tr>
	<th>ID</th><th>NOMBRE</th>
	<th>COORDENADA</th><th>ESTADO</th>
</tr>
<% 
			Planeta p=new Planeta();
			p=(Planeta)request.getAttribute("planeta");
			p=new PlanetaControler().getById(p);				
			%>
			<tr>
				<th><%=p.getIdPlaneta()%></th>	
				<th><%=p.getNombrePlaneta()%></th>
				<th><%=p.getCoordenada()%></th>
				<th><%=p.getEstado()%></th>
			</tr>
			<%				
%>
</table>
<form action="Planetas" method="post" >
  ID		: <input type="text" name="id" value="<%=p.getIdPlaneta()%>" readonly="readonly"><br>
  Nombre	: <input type="text" name="nombre"><br>
  Coordenada: <input type="text" name="coordenada"><br>
  Estado	: <input type="text" name="estado" ><br>
  			  <input type="hidden" name="accion" value="modificar">
  <input type="submit" value="Modificar">
</form>
</body>
</html>