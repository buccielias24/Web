package logic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
		ViajeController vc=new ViajeController();
		ArrayList<Viaje> viajes=vc.getAll();
			for(Viaje v:viajes)
			{
				System.out.println("llego aca, origen:"+v.getOrigen());
				System.out.println("----, destino:"+v.getDestino());
				System.out.println("parametro de entrada:"+p);
				
				
				if(v.getOrigen().equals(p)||v.getDestino().equals(p))
				{
					
					v.setEstado(1);
					v.setMotivo(1);
					vc.modify(v);
				}
			}
		dp.delete(p);
	}
	
	// ver como pasar la imagen del front hacia aca.
	public String encodeToString(BufferedImage image, String type)
	{
		String imageString=null;
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		try {
			ImageIO.write(image,type, bos);
			byte[] imageBytes =bos.toByteArray();
			
			BASE64Encoder encoder=new BASE64Encoder();
			imageString="data:image/jpeg;base64,"+encoder.encode(imageBytes);
			
			bos.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return imageString;
	}
	
	public Planeta getUltimo()
	{
		return dp.getLast();		 
	}
	
	
	public void modify(Planeta p)
		{
			if(p.getEstado()!=true || p.getEstado()!=false)
				{
					
				}
			   		dp.modify(p);
	}
}