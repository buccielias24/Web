package logic;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import entidades.*;

public class UtilController {

public JsonArray convertirJson(Ciudadano c,List<Planeta> planetas, List<Resenia> resenias) {	
	Gson gson = new Gson();
    JsonArray ja=new JsonArray();    
    String usuario= gson.toJson(c);
    
    for(Planeta p:planetas)
    		{
    	     JsonArray reseniasP=new JsonArray();
    		 JsonObject jo=new JsonObject(); 
    		 jo.addProperty("id_planeta", p.getId());
    		 jo.addProperty("nombre", p.getNombre());
    		 jo.addProperty("coordenadaX", p.getCoordenadaX());
    		 jo.addProperty("coordenadaY", p.getCoordenadaY());
    		 jo.addProperty("estado", p.getEstado());
    		 float puntaje=0;
    		 int contador=0;
    		 for(Resenia r:resenias) {
    			  if (r.getPlaneta().getId()==p.getId())
    			  {  
    				 JsonObject resenia=new JsonObject(); 
    				 resenia.addProperty("apelnom", r.getUsuario().getNombre().concat(", ").concat(r.getUsuario().getApellido())); 
    				 resenia.addProperty("puntaje", r.getPuntaje());
    				 resenia.addProperty("fecha", r.getFecha().toString());
    				 resenia.addProperty("comentario", r.getComentario());
    				 reseniasP.add(resenia);
    				 puntaje=puntaje+r.getPuntaje();
    				 contador++;
    			  }	  
    		  	}
    		 jo.add("resenias",reseniasP);
    		 if(contador!=0)
    		 {
    		 jo.addProperty("puntaje", puntaje/contador);
    		 }else {jo.addProperty("puntaje", 0);}
    		 ja.add(jo); 
    		}
    ja.add(usuario);
    return ja;
 	}
}
