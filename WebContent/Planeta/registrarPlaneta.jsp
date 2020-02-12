 <%@page import="entidades.Planeta"%>
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
<h1>Alta Planetas</h1>
<form action="/Web/Planetas" method="post" name="form" id="form" enctype="multipart/form-data">
  Nombre: <input type="text" id="inAlta1" name="inAlta1" value="" onKeyUp="habilitar('form')" ><br>
  Coordenada X: <input type="text" id="inAlta2" name="inAlta2" value="" onKeyUp="habilitar('form')"><br>
  Coordenada Y: <input type="text" id="inAlta3" name="inAlta3" value="" onKeyUp="habilitar('form')"><br>  
  Fecha Alta: <input type="Date" id="inAlta4" name="inAlta4" value="" onKeyUp="habilitar('form')"><br>
  Imagen: <input type="File" id="inputImagen" name="inputImagen" value=""><br> 
    <input type="submit" value="Agregar" id="altaSubmit" disabled='disabled' onclick="myFunction()"> 
</form>

</body>
</html>