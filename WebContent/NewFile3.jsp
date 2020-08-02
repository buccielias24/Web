	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Destinos</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
 
<style type="text/css">
body{
  background:url(https://wallpapercave.com/wp/wp3493593.jpg);
  background-size: cover;
}

.header {
  color: #ffffff;
  text-align: center;
  background-color:black;
}

.footer {
  color: #ffffff;
  text-align: center;
  font-size: 12px;
  padding: 15px;
}

.checked {
  color: yellow;
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

.carousel-control-next, .carousel-control-prev {
    top: 50% !important;
    bottom: 50% !important;
}

<!-- -->

@-webkit-keyframes planet-rotation {
    from {
        background-position: 0% 0%;
    }
    to {
        background-position: -200% 0%;
    }
}
@keyframes planet-rotation {
    from {
        background-position: 0% 0%;
    }
    to {
        background-position: -200% 0%;
    }
}


.planet-image {
     width: 25vw;
     height: 25vw;
     max-width: 512px;
     max-height: 512px;
     border-radius: 50%;
     position: relative;
     background-size: cover;
     -webkit-animation: planet-rotation 50s linear infinite;
     margin:auto;
}

.planet-image:after {
    position: absolute;
    content: '';
    top: -2px;
    left: -2px;
    right: -2px;
    bottom: -2px;
    
    height: 100%;
    border-radius: 50%;
    background-image:
        -webkit-radial-gradient(16% 50%, 30% 50%, rgba(255,240,230,.6), transparent),
        linear-gradient(to right, rgba(255,240,220,0.5) 12%, rgba(255,240,220,0) 40%, rgba(0,0,0,0.64) 60%, rgba(0,0,0,1) 100%);
    box-shadow: inset 10px 0 30px rgba(255,240,220,0.4);
}
.profilePicture{
    max-width:10%;
	border-radius: 50%;
}

.body{
	color:#ffffff;
	font-family: 'Roboto';
	font-size:22px;
	background-color:#262626;
	}
	
</style>

  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  	
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  
</head>
<header>  <jsp:include page="/header2.jsp"></jsp:include></header>
  <body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="carousel" id="carousel-610499" data-interval="false">
				<div class="carousel-inner" id="mycarousel">
		     		</div> <a class="carousel-control-prev" href="#carousel-610499" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-610499" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
			</div>
		</div>
	</div>
</div>

<!-- Modal Comentarios  -->			
			<div class="modal fade" id="modal-container-669121" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-xl" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">
								Modal title
							</h5> 
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="card">
 		 						<div class="card-header">
 		 							<img class="profilePicture" src="/Web/img/login.jpg">
 		 						</div>
  								<div class="card-body">
   								 <blockquote class="blockquote mb-0">
      							 <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
      							 <footer class="blockquote-footer">Someone famous in <cite title="Source Title">Source Title</cite></footer>
    				             </blockquote>
  								</div>
							</div>
							<div class="card">
 		 						<div class="card-header">Quote
 		 						</div>
  								<div class="card-body">
   								 <blockquote class="blockquote mb-0">
      							 <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
      							 <footer class="blockquote-footer">Someone famous in <cite title="Source Title">Source Title</cite></footer>
    				             </blockquote>
  								</div>
							</div>
							<div class="card">
 		 						<div class="card-header">Quote
 		 						</div>
  								<div class="card-body">
   								 <blockquote class="blockquote mb-0">
      							 <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
      							 <footer class="blockquote-footer">Someone famous in <cite title="Source Title">Source Title</cite></footer>
    				             </blockquote>
  								</div>
							</div>														
						</div>
						<div class="modal-footer">
							 
							<button type="button" class="btn btn-primary">
								Save changes
							</button> 
							<button type="button" class="btn btn-secondary" data-dismiss="modal">
								Close
							</button>
						</div>
					</div>
					
				</div>
				
			</div>
<!--  FIN modal Comentarios -->
<script>
 
 $(document).ready(function() {
     $.ajax({
            type:"GET",
            url:"Planetas"
        })
        .done(function (data) {
       	  data.pop();
       		 $.each( data, function( key, val ) {
       		   if (key==0){
          		   cabecera='<div class="carousel-item active">';	
          		}else{
          			cabecera='<div class="carousel-item">';
          		}
       		    //estrellas
       				var puntaje=parseInt(val.puntaje);
            		var j=0;
            		var estrellas='';
            	     for(j=0; j<5;j++){
           	 	      if(puntaje>j){
           	 			estrellas=estrellas+('<span class="fa fa-star checked"></span>');}
           	 	      else{
           	 		    estrellas=estrellas+('<span class="fa fa-star"></span>');	}   
   	                 }
				var planeta=
					cabecera+
					'<div class="container-fluid" ><div class="row"><div class="col-md-2"><div class="menu" style="padding-top:10%">'+
					'<ul><li class="list-item">Viajes a este destino</li><li class="list-item"><a id="modal-669121" href="#modal-container-669121" data-toggle="modal">Comentarios</a></li>'+
					'<li class="list-item">Otros</li></ul></div></div>'+
					'<div class="col-md-8"><div class="row"><div class="col-md-12"><div class="header"><h1>'+val.nombre+'</h1></div>'+ 
					'</div></div><div class="row"><div class="col-md-12" style="padding-top: 10px">'+
					'<div class="planet-image" style="background-image:url('+val.url+')"></div>'+'<div class="col-md-12"><div class="footer" style="margin-top:1%"><h4>'+estrellas+'</h4></div></div>'+
					'</div></div></div><div class="col-md-2" style="padding-top: 10%"><div class="aside">DATOS EXTRAS'+
					'</div></div>'+
				  '</div></div>';
				  $('#mycarousel').append(planeta); 	
          	  }); 
        });
});
 </script>
  
  </body>
</html>