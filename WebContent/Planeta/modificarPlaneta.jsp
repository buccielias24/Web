<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="java.util.ArrayList"%>
<html>
<body>
<h1>Modificar</h1>

<% 
			Planeta p=new Planeta();
			p=(Planeta)request.getAttribute("planeta");
			p=new PlanetaControler().getById(p);				
			%>

<form action="/Web/Modificar" method="post" >
  ID		: <input type="text" name="id" value="<%=p.getIdPlaneta()%>" readonly="readonly"><br>
  Nombre	: <input type="text" name="nombre" value="<%=p.getNombrePlaneta()%>"><br>
  Estado	: <input type="text" name="estado" value="<%=p.getEstado()%>" ><br>
  			  <input type="hidden" name="accion" value="modificar">
  <input type="submit" value="Modificar">
</form>
</body>
</html>