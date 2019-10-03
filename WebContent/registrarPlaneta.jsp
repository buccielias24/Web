  <%@page import="entidades.Planeta"%>
<html>
<body>
<h1>Alta Planetas</h1>
<h2>Ingrese los datos del planeta</h2>
<table>
<tr>
	<th>ID</th><th>NOMBRE</th>
	<th>COORDENADA</th><th>ESTADO</th>
</tr>
</table>
<form action="Planetas" method="post">
  Nombre Planeta: <input type="text" name="nombre"><br>
  Coordenada: <input type="text" name="coordenada"><br>
  Estado: <input type="text" name="estado"><br>
  		  <input type="hidden" id="accion" name="accion" value="agregar">
	  <input type="submit" value="Agregar">
</form>

</body>
</html>