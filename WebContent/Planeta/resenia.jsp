<%@page import="entidades.Planeta"%>
<%@page import="entidades.Ciudadano"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>

<link href="/Web/css/star-rating.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="js/jquery.rating.pack.js"></script>
<script>
$(document).ready(function(){
    $('input.star').rating();
});
</script>
</head>
<body>
<% Planeta p=(Planeta)session.getAttribute("planeta");%>
<form action="/Web/resenia" method="post">
	<div>
		<label>Ingrese su comentario</label>
		<input type="text" name="comment"> 
		<input type="hidden" name=planeta value="<%=p.getIdPlaneta()%>">
	</div>	
    <div class="star_content">
        <input name="rate" value="1" type="radio" class="star"/> 
        <input name="rate" value="2" type="radio" class="star"/> 
        <input name="rate" value="3" type="radio" class="star"/> 
        <input name="rate" value="4" type="radio" class="star" checked="checked"/> 
        <input name="rate" value="5" type="radio" class="star"/>
    </div>
    <button type="submit" name="submitRatingStar" id="submitRatingStar" class="btn btn-primary btn-sm">Enviar</button>
</form>
</body>
</html> 