package logic;

import java.util.ArrayList;

import entidades.Astrobus;

public class ControlAutobus {

	public ArrayList<Astrobus> getAll(){
		ArrayList<Astrobus> astrobuses=new ArrayList<Astrobus>();
		Astrobus a = new Astrobus();
		a.setMarca("Firefly");
		astrobuses.add(a);
		return astrobuses;
	}
}
