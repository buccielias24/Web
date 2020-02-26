package logic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import data.DataPlaneta;
import entidades.*;
import sun.misc.BASE64Encoder;

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
	
	public int add(Planeta p, Ciudadano c) {
		
		if(c!=null && c.getRol()==1)
			{
				if(planetaExiste(p)){
					p.setEstado(true);	
					dp.add(p);	
				return 0;}else {
				System.out.println("planeta existe");
				return 1;}
			}
			else {
					System.out.println("no esta logeado");
					return 2;
				 }
		
	}
	
	public boolean planetaExiste(Planeta pla)
	{
		boolean validar=true;
		ArrayList<Planeta>planetas=this.getAll();
		for (Planeta p:planetas)
		{
			 if(p.getCoordenadaX()==pla.getCoordenadaX()&&p.getCoordenadaY()==pla.getCoordenadaY())
				 {validar=false;
				  System.out.println("Coordenada duplicada");
				 break;}else
				 {
					 if(p.getNombrePlaneta().equals(pla.getNombrePlaneta()))
							 {
						 		validar=false;
						 		System.out.println("Nombre planeta duplicado");
						 		break;
							 }
				 }
		}
		return validar;
	}
	
	
	public void modify(Planeta p)
		{
			dp.modify(p);
		}
	public void baja(Planeta p)
	{
		dp.baja(p);
	}
}