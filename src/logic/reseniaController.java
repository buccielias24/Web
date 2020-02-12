package logic;

import java.util.ArrayList;
import java.util.Date;

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
	public double getPuntaje(Planeta p)
	{
		ArrayList<Resenia>resenias=dr.getAll(p);
		double tot=0;
		int i=0;
			for(Resenia res:resenias)
			{
				tot=tot+res.getPuntaje();
				i++;
			}
			return tot/i;
	}	
	
	public void add(Resenia r)
	{
		if(r.getUsuario()!=null)
		{
			Date ahora=new Date();
			java.sql.Date sDate=new java.sql.Date(ahora.getTime());
			r.setFecha(sDate);
			dr.add(r);
		}
	}
	
	
	public Resenia existResenia(Ciudadano ciud, Planeta p)
	{
		Resenia r=new Resenia();
		if(ciud.getRol()==0 || ciud.getRol()==1)
		{
			ArrayList<Resenia> resenias=dr.getAll(p);
				for(Resenia res:resenias)						
					{
						if(res.getPlaneta().getIdPlaneta()==p.getIdPlaneta() && res.getUsuario().getDgu()==ciud.getDgu())
							{
							r=res;
						}
					}
		}
		return r;
	}
	
}
