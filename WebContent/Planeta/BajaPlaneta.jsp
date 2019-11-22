<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="java.util.ArrayList"%>
<html>
<body>
<h3>Baja</h3>
<br>
<br>
<form action="/Web/Planetas" method="post">
<%	PlanetaControler pc=new PlanetaControler();	
	Planeta p=pc.getById((Planeta)request.getAttribute("planeta"));
%>
  <label><%=p.getIdPlaneta()%></label>	
  <input type="datetime">Fecha Baja
  <label>Comentario</label>
  <textarea rows="10" cols="100"></textarea> 
</form>
</body>
</html>