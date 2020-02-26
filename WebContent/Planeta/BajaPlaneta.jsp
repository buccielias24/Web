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
 <input type="text" id="idPlaneta" name="idPlaneta" value="<%=p.getIdPlaneta()%>"><br>	
 Motivo Baja :<input type="text" id="motivoBaja" name="motivoBaja"><br>
 <input type="submit" value="aceptar">
</form>
</body>
</html>