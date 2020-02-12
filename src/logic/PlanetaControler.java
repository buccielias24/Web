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
		/*ViajeController vc=new ViajeController();
		ArrayList<Viaje> viajes=vc.getAll();
			for(Viaje v:viajes)
			{
				if(v.getOrigen().equals(p)||v.getDestino().equals(p))
				{
					
					v.setEstado(1);
					v.setMotivo(1);
					vc.modify(v);
				}
			}*/
		System.out.println(p);
		dp.delete(p);
	}
	
	
	public Planeta getUltimo()
	{
		return dp.getLast();		 
	}
	
	
	public void modify(Planeta p)
		{
			if(p.getEstado()==true)
			{
				p.setFecha_baja(null);
				dp.modify(p);	
			}
		}
}