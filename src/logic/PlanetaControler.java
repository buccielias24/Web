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
	
	public void modify(Planeta p)
	{
		dp.modify(p);
	}
	
	public int add(Planeta p, Ciudadano c) {
			
	/*	if(planetaExiste(p))
			{return 0;}
				else {
					p.setEstado(true);	
					dp.add(p);	
					return 1;}*/
		p.setEstado(true);
		dp.add(p);
		return 1;
	}
	
	public boolean planetaExiste(Planeta pla)
	{
			boolean validar=false;
			ArrayList<Planeta>planetas=this.getAll();
				for (Planeta p:planetas)
					{
					 if(p.getCoordenadaX()==pla.getCoordenadaX()&&p.getCoordenadaY()==pla.getCoordenadaY() || p.getNombre().equalsIgnoreCase(pla.getNombre()))
					 	{	
						 	System.out.println("Planeta Existe");
						 	validar=false;
						 	break;}
					 else
						 {
						 	if(p.getNombre().equals(pla.getNombre()))
						 		{
						 			System.out.println("Planeta Existe");
						 			validar=false;
						 			break;												
						 		}
					     }
					}
				return validar;
	}
	
}