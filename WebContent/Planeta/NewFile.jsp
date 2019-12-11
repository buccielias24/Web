<%@page import="entidades.Ciudadano"%>
<%@page import="entidades.Planeta"%>
<%@page import="entidades.Resenia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.reseniaController"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!--
Author : Maniruzzaman Akash
Email  : manirujjamanakash@gmail.com
-->

<!--To Work with icons-->
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

<div class="container">
	<h2 class="text-center">Comentarios</h2>

<% 	
		reseniaController rc=new reseniaController();
			ArrayList<Resenia> resenias=rc.getAll((Planeta)request.getAttribute("planeta"));				
			for(Resenia res:resenias)
					{
							System.out.println(res.getUsuario().getApellido());
				
					%>	
	<div class="card">
	    <div class="card-body">
	        <div class="row">
        	    <div class="col-md-2">
        	        <img src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid"/>
        	        <p class="text-secondary text-center"><%=res.getFecha()%></p>
        	    </div>
        	    <div class="col-md-10">
        	        <p>
        	            <a class="float-left" href="https://maniruzzaman-akash.blogspot.com/p/contact.html"><strong><%=res.getUsuario().getApellido()%>,<%=res.getUsuario().getNombre()%></strong></a>
        	           <% for(int i=0;i<res.getPuntaje();i++){%>
        	            <span class="float-right"><i class="text-warning fa fa-star"></i></span>
				<%}%>
        	          
        	       </p>
        	       <div class="clearfix"></div>
        	        <p><%=res.getComentario()%>></p>      
        	        <p>
        	            <a class="float-right btn btn-outline-primary ml-2"> <i class="fa fa-reply"></i> Reply</a>
        	            <a class="float-right btn text-white btn-danger"> <i class="fa fa-heart"></i> Like</a>
        	       </p>
        	    </div>
	        </div>
	        	
	    </div>
	</div>
	<%}%>
</div>