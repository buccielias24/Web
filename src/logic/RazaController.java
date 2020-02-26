package logic;

import java.util.ArrayList;

import data.DataRaza;
import data.DataResenia;
import entidades.Raza;

public class RazaController {
	
	DataRaza dr;
	public RazaController() {
		dr=new DataRaza();
	}
	public ArrayList<Raza>getAll()
		{	
		return dr.getAll();
		}
	public Raza getByID(int ID)
	{
		return dr.getById(ID);
	}
}
