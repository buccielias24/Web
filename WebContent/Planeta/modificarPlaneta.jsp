<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
</head>
<body>
<h1>Modificar</h1>

<% 
			Planeta p=new Planeta();
			p=(Planeta)request.getAttribute("planeta");
			p=new PlanetaControler().getById(p);				
			%>

<form action="/Web/Modificar" method="post" id="form">
  ID		: <input type="text" name="id" value="<%=p.getIdPlaneta()%>" readonly="readonly"><br>
  Nombre	: <input type="text" name="nombre" value="<%=p.getNombrePlaneta()%>"><br>
  Coordenada X: <input type="text" name="coordenadaX" value="<%=p.getCoordenadaX()%>"><br> 
  Coordenada Y: <input type="text" name="coordenadaY" value="<%=p.getCoordenadaY()%>"><br>
  			 <%if (!p.getEstado()) {%>
  Volver a dar de alta este planeta:<input type="checkbox" id="estado" name="estado" value="true"><%}%>
  <input type="hidden" name="accion" value="modificar">
  <input type="submit" value="Modificar" onclick="setTimeout(window.close();,2000);">
</form>
</body>
</html>