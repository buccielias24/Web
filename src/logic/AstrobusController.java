package logic;

import java.util.ArrayList;

import data.DataAstrobus;
import entidades.Astrobus;
import entidades.Planeta;
import entidades.Viaje;


public class AstrobusController {

	DataAstrobus da;
	
	public AstrobusController() {
		da=new DataAstrobus();
	}
	
	public ArrayList<Astrobus> getAll(){
		return da.getAll();
	}
	
	//se agrega metodo que devuelve los astrobuses disponibles
	public ArrayList<Astrobus> getDisponibles(){
		ArrayList<Astrobus>astrobuses=da.getAll();
		ArrayList<Astrobus>disponibles=new ArrayList<Astrobus>();
		for(Astrobus a:astrobuses)
				{
					if(a.getEstado())
					{
						disponibles.add(a);
					}
				}
		return disponibles;
	}	
		
	public void add(Astrobus a) {
		da.add(a); 
	}
	public Astrobus getById(Astrobus a) {
		return da.getById(a);
		
	}
	
	public void modify(Astrobus a)
	{
		da.modify(a);
	}
	
	public Astrobus getCercano(Planeta p)
	{
		ArrayList<Astrobus> libres=this.getDisponibles();
		int count=0;
		double distminima=0;
		Astrobus cercano=new Astrobus();
			for(Astrobus a:libres)
			{
					if(count==0)
					{	
						distminima=Math.sqrt(Math.pow(p.getCoordenadaX()-a.getCoordenadaX(), 2)+Math.pow(p.getCoordenadaY()-a.getCoordenadaY(), 2));		
						cercano=a;
						count++;
					}
					else 
						{
							if(distminima>Math.sqrt(Math.pow(p.getCoordenadaX()-a.getCoordenadaX(), 2)+Math.pow(p.getCoordenadaY()-a.getCoordenadaY(), 2)))
							{
								distminima=Math.sqrt(Math.pow(p.getCoordenadaX()-a.getCoordenadaX(), 2)+Math.pow(p.getCoordenadaY()-a.getCoordenadaY(), 2));
								cercano=a;
							}
						}
				
					System.out.println("ID NAVE "+a.getIdNave()+"Distancia minima: "+distminima);
			}
			System.out.println("el astrobus mas cercano es : "+cercano);
			return cercano;
	}
	
}
