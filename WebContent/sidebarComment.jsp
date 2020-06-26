<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<style>
body {
  font-family: "Lato", sans-serif;
}

.sidebar {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidebar a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sidebar a:hover {
  color: #f1f1f1;
}

.sidebar .closebtn {
  position: absolute;
  top: 50%;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

.openbtn {
  position:absolute;
  top:10%;
  font-size: 20px;
  cursor: pointer;
  background-color: #111;
  color: white;
  padding: 10px 15px;
  border: none;
}

.openbtn:hover {
  background-color: #444;
}

#main {
  transition: margin-left .5s;
  padding: 16px;
}

</style>
</head>
<body>
<div id="mySidebar" class="sidebar">
</div>

<script>

function openNav(resenias) {
  completeComment(resenias);
  document.getElementById("mySidebar").style.width = "400px";
  document.getElementById("main").style.marginLeft = "400px";
}

function closeNav() {
  document.getElementById("mySidebar").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}

function completeComment(resenias){
	$('#mySidebar').empty();
	var body=$('#mySidebar'); 	   	   
	 $.each( resenias, function( key, val ) {
		body.append('<div class="card"><div class="card-body"><div class="row"><div class="col-md-4">'+
				  '<img src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid"/>'+
				   '<p class="text-secondary text-center">'+val.fecha+'</p></div>'+
				    '<div class="col-md-4"><p>'+
				     '<a class="float-left" href="https://maniruzzaman-akash.blogspot.com/p/contact.html"><strong>'+val.apelnom+'</strong></a>'+
				      '<span class="float-right">'+"estrellas"+'</span> </p>'+
				       '<p id="comment">'+val.comentario+'</p>'+      
				       	   '</p></div></div> </div></div></div>');
	 	
	 });
	 $('#mySidebar').append('<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">></a>');		
}
</script>
</body>
</html>