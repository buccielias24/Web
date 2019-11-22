package logic;

import data.DataUser;
import entidades.Ciudadano;


public class UserController {
	DataUser du;
	
	public UserController() {
		du=new DataUser();
	}
	
	public Ciudadano getById(Ciudadano ciud)
	{
		return du.getById(ciud);	
	}
		
	public Boolean userExist(Ciudadano ciud)
	{
		try {
		Ciudadano c=new Ciudadano();
	    c=getById(ciud);
		if(c.getUser().equals(ciud.getUser())&&c.getPassword().equals(ciud.getPassword()))
	    {	
	    	return true;
	    }
	    else
	    	return false;
		}catch(Exception e){return false;}	
		
	}
	
		
	}
