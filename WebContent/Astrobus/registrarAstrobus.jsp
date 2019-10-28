<%@page import="entidades.Astrobus"%>
<html>
<body>
<h1>Alta Astrobus</h1>
<h2>Ingrese los datos del astrobus</h2>
<form action="CargaAstrobus" method="post">
  Marca: <input type="text" name="marca" required><br>  
  Cantidad de asientos: <input type="text" name="cantAsientos" required><br>
  Distancia limite: <input type="text" name="distLimite" required><br>
  Distancia previa a service:<input type="text" name="distService" required><br>
  Estado: <input type="text" name="estado" required value="true"><br>
  <input type="submit" value="Agregar">
</form>
</body>
</html>