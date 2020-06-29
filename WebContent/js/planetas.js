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
				var planeta=cabecera+
					'<div class="container-fluid" ><div class="row"><div class="col-md-2"><div class="menu" style="padding-top:10%">'+
					'<ul><li class="list-item">Viajes a este destino</li><li class="list-item">Comentarios</li>'
						'<li class="list-item">Otros</li></ul></div></div>'
					'<div class="col-md-8"><div class="row"><div class="col-md-12"><div class="header"><h1>'+val.nombre+'</h1></div>' 
					'</div></div><div class="row"><div class="col-md-12" style="padding-top: 10px"><div class="background"></div>'
					'</div></div></div><div class="col-md-2"><div class="aside"><h2>Información</h2><p>Superficie terrestre:</p>'
					'</div></div><div class="col-md-12"><div class="footer" style="margin-top:5%"><h4>*****</h4>'
				  '</div></div></div></div>';
 				document.getElementById('name_'+val.id_planeta).innerHTML=val.nombre;
          	  }); 
        });
});