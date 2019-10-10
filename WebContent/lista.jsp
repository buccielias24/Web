<%@page import="entidades.Planeta"%>
<%@page import="logic.PlanetaControler"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado</title>
</head>
<body>	

<script>
function filtrar() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("th")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script>

	<h3>LISTADO DE PLANETAS</h3>
	<table id="Encabezado">
	<tr>
	<td>Id</td><th>Nombre</th>
	<th>Coordenada</th><th>Estado</th>
	<th>Accion</th>
	</tr>
	</table>
	
	<input type="text" id="myInput" onkeyup="filtrar()" placeholder="Search Planets..">
<table id="myTable">	
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
				<th><a href="Modificar?id=<%=p.getIdPlaneta()%>">Modificar</a></th>
			</tr>
			<%
			}					
		}catch(Exception e) {}
%>
</table>
</body>
</html>