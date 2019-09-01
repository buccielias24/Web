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
}