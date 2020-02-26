 <%@page import="entidades.Astrobus"%>
<html>
<head>

<script >
		function habilitar(A){
			if(document.getElementById(A)){
				var formObj=document.getElementById(A);
					if(formObj.inAlta1.value!=""&&
						formObj.inAlta2.value!=""&&
						formObj.inAlta3.value!=""&&
						formObj.inAlta4.value!="")
					{
						formObj.altaSubmit.disabled=false;
					}else{formObj.altaSubmit.disabled=true;}						
			}
		}
</script>
</head>
<body>
<h1>Alta Astrobuses</h1>
<h2>Ingrese los datos del Astrobus</h2>
<table>
<tr>
	<th>ID</th>
	<th>ESTADO</th>
</tr>
</table>
<form action="/Web/Astrobus" method="post" id="form" enctype="multipart/form-data">
  Cantidad de Asientos: <input type="text" id="cantAsientos" name="cantAsientos" value="" onKeyUp="habilitar('form')" ><br>
  Distancia Limite: <input type="text" id="distLimite" name="distLimite" value="" onKeyUp="habilitar('form')"><br>
  Distancia por cada service: <input type="text" id="distService" name="distService" value="" onKeyUp="habilitar('form')"><br>
<input type="submit" value="Agregar" id="altaSubmit" onclick="form.submit();alert('Astrobus Agregado');window.close()" >
  	  <input type="hidden" id="accion" name="accion" value="alta">
</form>
</body>
</html>