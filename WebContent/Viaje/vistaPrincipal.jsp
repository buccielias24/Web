
<%@page import="entidades.Ciudadano"%>
<%@page import="entidades.Astrobus"%>
<%@page import="logic.AstrobusController"%>
<%@page import="logic.PlanetaControler"%>
<%@page import="entidades.Planeta"%>
<%@page import="logic.ViajeController"%>
<%@page import="entidades.Viaje"%>
<%@page import="java.util.ArrayList"%>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    
    <title>Viajes</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/grid/">

    <!-- Bootstrap core CSS -->
<link href="/Web/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">	
<script type="text/javascript">
	var auto=setInterval(function refresh()
	{
		$("#refresh").load("tabla.jsp");},5000);
	refresh();
</script>

<script src="/Web/js/popup-center.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<style>
.column {
  float: left;
  width: 33.33%;
  padding: 50px;
  text-align: center;
  font-size: 25px;
  cursor: pointer;
  color: white;
}

.containerTab {
  padding: 20px;
  color: white;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Closable button inside the image */
.closebtn {
  float: right;
  color: white;
  font-size: 35px;
  cursor: pointer;
}

    .linea
{
    display: inline-block;
}
    
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
p.partiendo{
  font-size:2rem;
  margin: 45px;
}
    </style>

    
    <!-- Custom styles for this template -->
    <link href="/Web/css/grid.css" rel="stylesheet">
  </head>
  
  <header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <% if(session.getAttribute("user")==null)
    	{%>
    <a class="navbar-brand" href="/Web/login.jsp">Login</a>
    	<% }else {%>
    <a class="navbar-brand" href="logout">Logout</a>    
    	<%} %>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
       <% try{ 
    	Ciudadano c=new Ciudadano();	
		c=(Ciudadano)session.getAttribute("user");
	    %> 
          <a class="nav-link disabled" href="#"><%=c.getUser()%></a><%}catch(Exception e){ %>
          <a class="nav-link disabled" href="#">-</a><%}%>
        </li>
      </ul>
      <form class="form-inline mt-2 mt-md-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
</header>
  
  <body class="py-4">

<h1>PRUEBA</h1>
<form action="/Web/vistaViaje" method="get">
<select id="origen" name="origen" >
		<option disabled selected> -- select an option -- </option>
<% ArrayList<Planeta> planetas=new PlanetaControler().getAll();
		for(Planeta p:planetas)
		{%>
		<option value="<%=p.getIdPlaneta()%>"><%=p.getNombrePlaneta()%></option>				
		<%}%>
</select>
<input type="submit" value="Aceptar">
</form>
<%
session.setAttribute("idPlaneta", request.getAttribute("idPlaneta"));
%>
<input type="submit" value="">
   <div class="container" id="refresh">
		<jsp:include page="tabla.jsp"/>
	
</div> <!-- /container -->
</body></html>

