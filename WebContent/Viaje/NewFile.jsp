<%@page import="entidades.Viaje"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Viajes</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("tr").each(function(){
        var date1=new Date();
        var stringFecha = $(this).find("td:eq(3)").text();
        var date2=new Date(stringFecha);
          if(date1.getTime()>date2.getTime())
          {
        	$(this).find("td:eq(4)").html("Vuelo ya realizado");
        	$("#tableViaje2 tbody").append(this);
          }else
          {
          	$(this).find("td:eq(4)").html("Vuelvo disponible");
         }
   });   
});
</script>

</head>
<body>
<table  class="table" id="tableViaje">
    <thead class="thead-dark">
        <tr>
       		<th scope="col">Origen</th>
        	<th scope="col">Destino</th>
         	<th scope="col">Fecha y Hora Salida</th>
          	<th scope="col">Fecha Y Hora Llegada</th>
           	<th scope="col">Estado</th>
   		    <th scope="col">Astrobus</th>	
       </tr>
     </thead>
    <tbody id="myTbody">
  		<% ArrayList<Viaje> viajes=(ArrayList<Viaje>)request.getAttribute("arribos");
  			try{						
				for(Viaje v:viajes){										%>
    				<tr>
  				    <td><%=v.getOrigen().getNombrePlaneta()%></td>  
      				<td><%=v.getDestino().getNombrePlaneta()%></td>
      				<td id="salidaViaje"><%=v.getSalida()%></td>
      				<td id="llegadaViaje"><%=v.getLlegada()%></td>
	  				<td id="estadoViaje"></td>
      				<td><a href="/Web/cargaastrobus?id=<%=v.getAstrobus().getIdNave()%>"><%=v.getAstrobus().getMarca()%>, Patente: <%=v.getAstrobus().getIdNave()%></a></td>
					</tr> <%}					
		}catch(Exception e) {}%>
 	</tbody>
</table>
<h3>Tabla2</h3><table id="tableViaje2"><tbody><tr><td></td></tr></tbody></table>
</body>
</html>