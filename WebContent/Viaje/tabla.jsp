<%@page import="entidades.Viaje"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.ViajeController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#cancelado{
background-color:#E11637;
border-style:outset;
}
#normal{
background-color:#0AF222;
border-style:outset;
}
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table id="refresh"class="table">
  <thead class="thead-dark">
     <tr>
      <th scope="col">ID</th>
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
  	<% 
		try{
			int e=0;
			ViajeController vc=new ViajeController();
			ArrayList<Viaje> viajes=new ViajeController().getAll();			
				if(session.getAttribute("idPlaneta")!=null)
				{e=(Integer)session.getAttribute("idPlaneta");}
			for(Viaje v:viajes){
			  if(v.getOrigen().getIdPlaneta()==e || e==0)
			  {
			%>
    <tr>
      <th scope="row"><%=v.getIdViaje()%></th>
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
  	<%
			  }	
			}					
		}catch(Exception e) {}
%>
 </tbody>
</table>	
</body>
</html>