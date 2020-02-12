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
 <input type="text" id="inBaja1" name="inBaja1" value="<%=p.getIdPlaneta()%>"><br>	
 Fecha :<input type="datetime-local" id="inBaja2" name="inBaja2"><br>
 Comentario: <textarea rows="10" cols="100" id="inBaja3" name="inBaja3"></textarea><br> 
 <input type="submit" value="aceptar">
</form>
</body>
</html>