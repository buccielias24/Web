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
	public ArrayList<Planeta> getById(int id){
		return dp.getById(id);
	}
	
	public void add(Planeta p) {
		dp.add(p); 
	}
	public void delete(int id) {
		dp.delete(id);
	}
	public void modify(int id, String nombre, String coordenada)
		{dp.modify(id,nombre,coordenada);
	}
}