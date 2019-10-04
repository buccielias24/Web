<%@page import="entidades.Astrobus"%>
<html>
<body>
<h1>Alta Astrobus</h1>
<h2>Ingrese los datos del astrobus</h2>
<table>
<tr>
	<th>CANTIDAD DE ASIENTOS</th>
	<th>DITANCIA LIMITE DE VIAJE</th><th>DISTANCIA PREVIA A SERVICE</th>
	<th>ESTADO</th>
</tr>
</table>
<form action="CargaAstrobus" method="post">
  Cantidad de asientos: <input type="text" name="cantAsientos"><br>
  Distancia limite: <input type="text" name="distLimite"><br>
  Distancia previa a service:<input type="text" name="distService"><br>
  Estado: <input type="text" name="estado"><br>
  <input type="submit" value="Agregar">
</form>
</body>
</html>