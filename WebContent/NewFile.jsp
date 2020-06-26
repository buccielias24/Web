<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Home</title>
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
     $.ajax({
            type:"GET",
            url:"http://localhost:8080/Web/Planetas"
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
				planetas=cabecera
                    +'<div class="d-flex align-items-center justify-content-center min-vh-100">'+
                '<div class="planet"> <div class="wrap">'+
 				  '<div id='+val.id_planeta+' class="background"></div>'
 				   +'</div><div class="mask"></div></div></div>'+
 				   '<div id="feed_'+val.id_planeta+'" class="rating"></div>'+
 				  '<div id="name_'+val.id_planeta+'" class="nombrePlaneta"></div>'+
 				 "<div class='comment'><a onclick='openNav("+JSON.stringify(val.resenias)+")'>(0)</a></div></div>";		
 				$('#planetas').append(planetas); 			                      
 				document.getElementById('name_'+val.id_planeta).innerHTML=val.nombre;
 				document.getElementById('feed_'+val.id_planeta).innerHTML=estrellas;
       			document.getElementById(val.id_planeta).style.background = "url("+val.url+") repeat-x";        			
          	  }); 
        });
});
</script>

<style type="text/css">
body{
  background:url(https://wallpapercave.com/wp/wp3493593.jpg) repeat;
}
.checked {
  color: yellow;
}
.comment{
 font-size:30px;
 position:absolute;
 left:57%;
 top:79%;
 margin:0px;
 
}
.nombrePlaneta{
 background-color:black;
 text-transform: uppercase;
 font-size: 40px;
 color:white;
 position:absolute;
 left:43%;
 top:10%;
}
.rating{
 font-size:33px;
 position:absolute;
 left:43%;
 top:80%;
 margin:0px;
}
.planet .background{
  animation: translateBackground 40s infinite linear;  
  position:relative;
  width:50%;
  padding-bottom:50%;
  padding-left:50%;
  border-radius:50%;
}
@keyframes translateBackground{
  0%{
    background-position-x:0;
  }
  100%{
    background-position-x:-600px;
  }
}
</style>

</head>

<header>
   <jsp:include page="/header.jsp"></jsp:include>
</header>
  
<body>
<jsp:include page="/sidebarComment.jsp"></jsp:include>
<div id="main">
<div class="container-fluid px-0">
    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <div id="planetas" class="carousel-inner" role="listbox"> 
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
</div>
</body>
</html>