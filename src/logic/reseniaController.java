package logic;

import java.util.ArrayList;

import data.DataResenia;

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
	
}
