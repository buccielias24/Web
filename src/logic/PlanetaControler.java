package logic;

import java.util.ArrayList;
import data.DataPlaneta;
import entidades.*;

public class PlanetaControler {

			DataPlaneta dp;
	
	public PlanetaControler() {
		dp=new DataPlaneta();
	}
	
	public ArrayList<Planeta> getAll(){
		return dp.getAll();
	}
	public Planeta getById(Planeta pla){
		return dp.getById(pla);
	}
	
	public Boolean add(Planeta p, Ciudadano c) {
		
		if(c!=null && c.getRol()==1)
		{
		p.setEstado(true);
		dp.add(p);
		return true;
		}
		else {
		 	return false;
		}
		
	}
	
	public void delete(Planeta p) {
		dp.delete(p);
	}
	public void modify(Planeta p)
		{
			if(p.getEstado()!=true || p.getEstado()!=false)
				{
					
				}
			   		dp.modify(p);
	}
}