<%@page import="java.util.Date"%>
<%@page import="logic.UserController"%>
<%@page import="entidades.Ciudadano"%>
<%@page import="entidades.Planeta"%>
<%@page import="entidades.Resenia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.reseniaController"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="/Web/js/popup-center.js"></script>


<div class="container">
	<h2 class="text-center">Comentarios</h2>

<% 			
			int cont=0;
			Ciudadano c=new Ciudadano();
			c=(Ciudadano)session.getAttribute("user");
			if(c!=null){cont=1;}
			ArrayList<Resenia> resenias=(ArrayList<Resenia>)request.getAttribute("resenias");		
			for(Resenia res:resenias)
					{
					%>	
	<div class="card">
	    <div class="card-body">
	        <div class="row">
        	    <div class="col-md-2">
        	        <img src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid"/>
        	        <p class="text-secondary text-center"><%=(Date)res.getFecha()%></p>
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
        	        <%
        	        System.out.println(c);
        	        	if (c!=null)
        	        	 {		
        	        		if(c.getRol()!=1 || c.getRol()!=0)
        	        			{
	
        	        				if(res.getUsuario().getDgu()==c.getDgu())
        	        					{cont=2;%>
        	       					 	<a class="float-right btn btn-outline-primary ml-2"> <i class="fa fa-reply"></i> Edit</a>
        	       						<%} else{%>
        	       							<p>
        	       	        	            <a class="float-right btn btn-outline-primary ml-2"> <i class="fa fa-reply"></i> Reply</a>
        	       	        	            <a class="float-right btn text-white btn-danger"> <i class="fa fa-heart"></i> Like</a>
        	       	        	       		</p>	
        	       						<%}
        	        			}
        	        	 }%>
        	          
        	    </div>
	        </div>   	
	    </div>
	</div>
	
	<%}
			session.setAttribute("planeta", request.getAttribute("planeta"));
			if(cont==1){%>
		<p><a class="btn btn-secondary" onclick="popupWindow('/Web/Planeta/resenia.jsp', 'test', window, 500, 250)" role="button">Comentario</a></p>
	<%}%>
</div>