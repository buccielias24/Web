 $(document).ready(function() {
	 $('#myModal').modal('hide');
      $.ajax({
             type:"GET",
             url:"http://localhost:8080/Web/Planetas"
         })
         .done(function (data) {
        	 var last = data[data.length - 1];
        	 if(last!="null"){
        		 $('#newPlaneta').append('<button id="new" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"><span class="oi oi-plus"></span></button>');
        	 		}	
        		 data.pop();
        		 $.each( data, function( key, val ) {		  
           		    tr = $('<tr class="text-center"/>');
                     tr.append('<td style="display:none;">' + val.id_planeta + "</td>");
                     tr.append("<td>" + val.nombre + "</td>");  
                     tr.append("<td>" + val.coordenadaX + "</td>"); 
                     tr.append("<td>" + val.coordenadaY + "</td>"); 
                     tr.append("<td>" + val.estado + "</td>"); 
                     // estrellas
                     var puntaje=parseInt(val.puntaje);
                     var j=0;
                     var estrellas='';
                     var total=0; 
               	   	 var i=0;
               	   	  for(j=0; j<5;j++){
                    	 	if(puntaje>j){
                    	 			estrellas=estrellas+('<span class="fa fa-star checked"></span>');}
                    	 	else{
                    	 		    estrellas=estrellas+('<span class="fa fa-star"></span>');	}   
            	      }
                     tr.append("<td>" + estrellas + "</td>");
                     for (i in val.resenias) {
                  	   total++;                         
                     } 
                     tr.append("<td><a onclick='completeComment("+JSON.stringify(val.resenias)+")'>" + total + "</a></td>");                      	
                     if(last!='null')
                     {
                      tr.append("<td>" + '<button type="button" id="trigger_modal" class="btn btn-primary" data-toggle="modal" data-target="#myModal2">Editar</button>' + '<button style="margin-left: 10px;" type="button"  id="trigger_modal" class="btn btn-danger" data-toggle="modal" data-target="#myModalDelete">Eliminar</button>'  +"</td>");
                     }
                     $('#tablebody').append(tr);
           	  }); 
         });
 });