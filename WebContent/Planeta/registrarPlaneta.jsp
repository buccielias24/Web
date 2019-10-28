  <%@page import="entidades.Planeta"%>
<html>
<head>

<script >
		function habilitar(A){
			if(document.getElementById(A)){
				var formObj=document.getElementById(A);
					if(formObj.inAlta1.value!=""&&
						formObj.inAlta2.value!=""&&
						formObj.inAlta3.value!=""){
						formObj.altaSubmit.disabled=false;
					}else{formObj.altaSubmit.disabled=true;}						
			}
			
		}
</script>

</head>
<body>
<h1>Alta Planetas</h1>
<h2>Ingrese los datos del planeta</h2>
<table>
<tr>
	<th>ID</th><th>NOMBRE</th>
	<th>COORDENADA</th><th>ESTADO</th>
</tr>
</table>
<form action="/Web/CargaPlaneta" method="post" id="form">
  Nombre Planeta: <input type="text" id="inAlta1" name="inAlta1" value="" onKeyUp="habilitar('form')" ><br>
  Coordenada: <input type="text" id="inAlta2" name="inAlta2" value="" onKeyUp="habilitar('form')"><br>
  Estado: <input type="text" id="inAlta3" name="inAlta3" value="true" onKeyUp="habilitar('form')" disabled><br>
	  <input type="submit" value="Agregar" id="altaSubmit" onclick="form.submit();alert('Planeta Agregado');window.close()" disabled='disabled'>
  	  <input type="hidden" id="accion" name="accion" value="alta">
</form>
</body>
</html>