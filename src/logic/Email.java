package logic;

import java.util.List;

import com.google.gson.JsonObject;

import entidades.Ciudadano;

public interface Email {
	
	public String apikey = "42fa2e2d8069288df3335ea6668ec280";
	
	//metodos utilizados para validar un correo (que no exista registrado y que responda al STMP)
	public JsonObject checkEmail(String email) throws Exception;
	public boolean validarNuevoEmail(Ciudadano c, List<Ciudadano> usuarios);
}
	