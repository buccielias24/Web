<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="entidades.Viaje"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.ViajeController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/grid/">

    <!-- Bootstrap core CSS -->
<link href="/Web/css/bootstrap.min.css" rel="stylesheet" >	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	var auto=setInterval(function refresh()
	{
		$("#refresh").load(location.href+'#refrescar');},300000);
</script>											
<style type="text/css">
#cancelado{
background-color:#E11637;
border-style:outset;
}
#normal{
background-color:#0AF222;
border-style:outset;
}
.table{ 
margin-top: 100px;
}

</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

 <jsp:include page="/header.jsp"></jsp:include>


<body>
<div id="refresh" class="container">
<h3 class="table">ULTIMOS ARRIBOS</h3>
<table  class="table" id="refrescar">

  <thead class="thead-dark">
    <tr>
       <th scope="col">Origen</th>
        <th scope="col">Destino</th>
         <th scope="col">Fecha y Hora Salida</th>
          <th scope="col">Fecha Y Hora Llegada</th>
           <th scope="col">Estado</th>
   		    <th scope="col">Motivo</th>
   		     <th scope="col">Distancia</th> 
   		      <th scope="col">Astrobus</th>	
     </tr>
  </thead>
  <tbody id="myTbody">
  	<% ArrayList<Viaje> viajes=(ArrayList<Viaje>)request.getAttribute("arribos");
  	try{						
							for(Viaje v:viajes){
								if(v.getEstado()==3)
								{
										%>
    <tr>
      <td><%=v.getOrigen().getNombrePlaneta()%></td>  <!-- Muestra el objeto entero Planeta ver para arreglar la vista -->
      <td><%=v.getDestino().getNombrePlaneta()%></td>
      <td><%=v.getSalida()%></td>
      <td><%=v.getLlegada()%></td>
	  <%switch(v.getEstado())
	  {
	  case 0:%><td>Planeado</td>     	 
 	 <% break;
   case 1:%><td><p id="partiendo">Partiendo</p></td>
 	 <% break;
   case 2:%><td id="encurso">En Curso</td>
 	  <%break;
   case 3:%><td><p id="llegando">Llegando</p></td>
 	  <%break;
   case 4:%><td><p id="cancelado">Cancelado</p></td>
 	  <%break;

	  
	  }%>	 
      
      <td><div id="feedback-bg-info"><%=v.getMotivo()%></div></td>
      <td><%=v.getDistancia()%></td>
	  <td><a href="/Web/cargaastrobus?id=<%=v.getAstrobus().getIdNave()%>"><%=v.getAstrobus().getMarca()%>, Patente: <%=v.getAstrobus().getIdNave()%></a></td>

	</tr>    
 
  	<%}
			  }	
								
		}catch(Exception e) {}
%>
 </tbody>
</table>	
		
<h3 class="table">VIAJES</h3>
<table  class="table" id="refrescar">
  <thead class="thead-dark">
    <tr>
       <th scope="col">Origen</th>
        <th scope="col">Destino</th>
         <th scope="col">Salida</th>
          <th scope="col">Llegada</th>
           	<th scope="col">Lunes</th>
     		 <th scope="col">Martes</th>
     		  <th scope="col">Miercoles</th>	
     			<th scope="col">Jueves</th>
     			  <th scope="col">Viernes</th>
     			  	<th scope="col">Sabado</th>
     			  	 <th scope="col">Domingo</th>	
     </tr>
  </thead>
  <tbody id="myTbody">
  	<%
  	try{						
		 for(Viaje v:viajes){
										%>
    <tr>
      <td><%=v.getOrigen().getNombrePlaneta()%></td>  
      <td><%=v.getDestino().getNombrePlaneta()%></td>
      <td><%=v.getSalida()%></td>
      <td><%=v.getLlegada()%></td>
	  <%
	  
	  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  Date transactionDateTime = simpleDateFormat.parse(v.getSalida());
	  Calendar c = Calendar.getInstance();
	  c.setTime(transactionDateTime);
	  int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	  System.out.println(dayOfWeek);	 %>
	     

  	<%}
			  }catch(Exception e) {}
%>
 </tbody>
</table>	

</div>
</body>
</html>