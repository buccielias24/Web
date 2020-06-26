<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bootstrap 4, from LayoutIt!</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
 
<style type="text/css">
body{
  background:url(https://wallpapercave.com/wp/wp3493593.jpg) repeat;
}


.background{
  animation: translateBackground 40s infinite linear;  
  background:url(http://localhost:8080/Web/img/tierra.png) repeat-x;
  position:relative;
  width:50%;
  padding-bottom:50%;
  padding-left:50%;
  border-radius:50%;
  margin:auto;
}  
.header {
  color: #ffffff;
  text-align: center;
  background-color:black;
}

.footer {
  background-color: black;
  color: #ffffff;
  text-align: center;
  font-size: 12px;
  padding: 15px;
}

.aside {
  background-color: #33b5e5;
  padding: 15px;
  color: #ffffff;
  text-align: center;
  font-size: 14px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}

.menu ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

.menu li {
  padding: 8px;
  margin-bottom: 7px;
  background-color: #33b5e5;
  color: #ffffff;
  box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}

.menu li:hover {
  background-color: #0099cc;
}

@keyframes translateBackground{
  0%{
    background-position-x:0;
  }
  100%{
    background-position-x:-600px;
  }
}
.carousel-control-next, .carousel-control-prev {
    top: 50% !important;
    bottom: 50% !important;
}
</style>

  </head>
  <body>
  <jsp:include page="/header2.jsp"></jsp:include>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="carousel slide" id="carousel-610499">
				<div class="carousel-inner">
					<div class="carousel-item active">
<div class="container-fluid" >
	<div class="row">
		<div class="col-md-2">
		  <div class="menu" style="padding-top:10%">
			<ul>
				<li class="list-item">
					Viajes a este destino
				</li>
				<li class="list-item">
					Comentarios
				</li>
				<li class="list-item">
					Otros
				</li>				
			</ul>
		  </div>	
		</div>
		<div class="col-md-8">
			<div class="row">
				<div class="col-md-12">
				<div class="header"><h1>Nombre Planeta</h1></div> 
				</div>
			</div>
			<div class="row">
				<div class="col-md-12" style="padding-top: 10px">
				<div class="background"></div>
				</div>
			</div>
		</div>
		<div class="col-md-2">
		 <div class="aside">	
			<h2>
				Información
			</h2>
			<p>
				Superficie terrestre:
				Superficie acuatica:
				Distancia al sol:
				Atmosfera:
			</p>
		  </div>	
		</div>
	  <div class="col-md-12">
	  <div class="footer" style="margin-top:5%">
	  <h4>*****</h4>
	  </div>
	  </div>
	</div>
</div>
				</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap Second" src="https://www.layoutit.com/img/sports-q-c-1600-500-2.jpg" />
						<div class="carousel-caption">
							<h4>
								Second Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap Third" src="https://www.layoutit.com/img/sports-q-c-1600-500-3.jpg" />
						<div class="carousel-caption">
							<h4>
								Third Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div> <a class="carousel-control-prev" href="#carousel-610499" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-610499" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
			</div>
		</div>
	</div>
</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>