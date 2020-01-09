<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="java.util.ArrayList"%>
<html>
<body>
<h3>Baja</h3>
<br>
<br>
<form action="/Web/BajaPlaneta" method="post">
<%	PlanetaControler pc=new PlanetaControler();	
	Planeta p=pc.getById((Planeta)request.getAttribute("planeta"));
%>
  <label><%=p.getIdPlaneta()%></label>	
  <input type="text" name="id" value="<%=p.getIdPlaneta()%>" readonly="readonly"><br>
  <input type="datetime">Fecha Baja
  <label>Comentario</label>
  <textarea rows="10" cols="100"></textarea> 
  <input type="submit" value="aceptar">
</form>
</body>
</html>