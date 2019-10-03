package logic;

import data.DataUser;
import entidades.Ciudadano;
import entidades.Viaje;

public class UserController {
	DataUser du;
	
	public UserController() {
		du=new DataUser();
	}
	
	public Ciudadano getById(Ciudadano ciud)
	{
		return du.getById(ciud);	
	}
	

}
