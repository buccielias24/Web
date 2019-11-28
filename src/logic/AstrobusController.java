package logic;

import java.util.ArrayList;

import data.DataAstrobus;
import entidades.Astrobus;


public class AstrobusController {

	DataAstrobus da;
	
	public AstrobusController() {
		da=new DataAstrobus();
	}
	
	public ArrayList<Astrobus> getAll(){
		return da.getAll();
	}
	
	public void add(Astrobus a) {
		da.add(a); 
	}
	public Astrobus getById(Astrobus a) {
		return da.getById(a);
		
	}
	public void updateAstroviaje(int id,double dr) {
		da.updateAstrobus(id, dr);
	}
	

}
