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
	
	public void add(Planeta p) {
		dp.add(p); 
	}
	public void delete(Planeta p) {
		dp.delete(p);
	}
	public void modify(Planeta p)
		{dp.modify(p);
	}
}