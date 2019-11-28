package logic;

import java.util.ArrayList;

import data.DataResenia;
import entidades.Ciudadano;
import entidades.Planeta;
import entidades.Resenia;

public class reseniaController {
		
	DataResenia dr;
	
	public reseniaController() {
		dr=new DataResenia();
	}
	
	public ArrayList<Resenia>getAll(Planeta p)
		{
			return dr.getAll(p);
			
		}
	public float getPuntaje(Planeta p)
	{
		ArrayList<Resenia>resenias=dr.getAll(p);
		float tot=0;
		int i=0;
			for(Resenia res:resenias)
			{
				tot=tot+res.getPuntaje();
				i++;
			}
			return tot/i;
	}	
	
	public int existResenia(Ciudadano ciud, Planeta p)
	{
		if(ciud.getRol()==0 || ciud.getRol()==1)
		{
			ArrayList<Resenia> resenias=dr.getAll(p);
				for(Resenia res:resenias)						
					{
					if(res.getIdPlaneta()==p.getIdPlaneta() && res.getDgu()==ciud.getDgu())
					{
					return 1;	
					}else
					{return 2;}
					}
			}
		return 3;
	}
	
}
