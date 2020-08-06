package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import entidades.Ciudadano;

public class ValidarCorreo implements Email {

	@Override
	public boolean validarNuevoEmail(Ciudadano c,List<Ciudadano> usuarios) {
		// TODO Auto-generated method stub
		boolean validar = false;
		for (Ciudadano usuario : usuarios) {
			if (usuario.getEmail().equalsIgnoreCase(c.getEmail())) {
				validar = true;
				break;
			}
		}
		return validar;
	}

	@Override
	public JsonObject checkEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		String url = "https://apilayer.net/api/check?access_key=" + apikey + "&email=" + email + "&smtp=1&format=1";

		URL urlobj = new URL(url);

		HttpURLConnection con = (HttpURLConnection) urlobj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", "Mozilla/17.0");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JsonObject correo = new JsonObject();

		Gson g = new Gson();
		correo = g.fromJson(response.toString(), JsonObject.class);

		JsonObject respuesta = new JsonObject();

		if (correo.get("smtp_check").toString().equalsIgnoreCase("true")) {
			respuesta.addProperty("error", "success");
		} else {
			respuesta.addProperty("error", correo.get("smtp_check").toString());
		}

		return respuesta;
	}


}
