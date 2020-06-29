<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Terminal Universal</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
	<style type="text/css">
	
	.body{
	color:#ffffff;
	font-family: 'Roboto';
	font-size:22px;
	background-color:#262626;
	}
	.header {
	  background-color: #191919;
	  color: #ffffff;
	  padding: 20px;
	  text-align: center;
}
	.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 75%;
}
	</style>

</head>
<header>
 <jsp:include page="/header2.jsp"></jsp:include></header>
<body class="body">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<div class="header">
						<h1 class="text-center">Terminal Universal <small>Bienvenido</small></h1>
					</div>
				</div>
			</div>
		</div>
		<div class="row" style="padding-top:5%">
			<div class="col-md-4">
				<img alt="ejemplo1" src="http://localhost:8080/Web/img/planeta.jpg" class="rounded-circle center"/>
				<div class="text-center">
					<h2>Planeta</h2>
					<p>Vea los destinos disponibles para viajar. Comentarios de viajantes</p>
					<button onclick="location.href='http://localhost:8080/Web/NewFile3.jsp'" class="btn btn-secondary">PLANETAS</button>
				</div>
			</div>
			<div class="col-md-4">
				<img alt="ejemplo1" src="http://localhost:8080/Web/img/planeta.jpg" class="rounded-circle center"/>
			</div>
			<div class="col-md-4">
				<img alt="ejemplo1" src="http://localhost:8080/Web/img/planeta.jpg" class="rounded-circle center"/>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				
				<h3 class="text-center">Pie de pagina</h3>
			</div>
		</div>
	</div>
	  <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  
</body>
</html>