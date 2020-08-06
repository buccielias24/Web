package logic;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import data.DataUser;
import entidades.Ciudadano;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import logic.ValidarCorreo;
public class UserController {

	private DataUser du;
	private ValidarCorreo vu;
//	private final String apikey = "42fa2e2d8069288df3335ea6668ec280";

	public UserController() {
		du = new DataUser();
		vu = new ValidarCorreo();
	}

	public Ciudadano getById(Ciudadano ciud) {
		return du.getById(ciud);
	}

	public ArrayList<Ciudadano> getAll() {
		return du.getAll();
	}

	public void addUser(Ciudadano user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		user.setRol(0);
		du.add(user);
		this.correo(user.getEmail());
	}

	public boolean validarNuevoUsuario(Ciudadano c) {
		boolean validar = false;
		for (Ciudadano usuario : this.getAll()) {
			if (usuario.getUser().equalsIgnoreCase(c.getUser())) {
				validar = true;
			}
		}
		return validar;
	}

//	public boolean validarNuevoEmail(Ciudadano c) {
//		boolean validar = false;
//		for (Ciudadano usuario : this.getAll()) {
//			if (usuario.getEmail().equalsIgnoreCase(c.getEmail())) {
//				validar = true;
//			}
//		}
//		return validar;
//	}

	public JsonObject nuevoUsuario(Ciudadano c) throws Exception {
		JsonObject respuesta = new JsonObject();
		if (!this.isStrongPassword(c.getPassword())) {
			respuesta.addProperty("error", "notstrong");
		} else {
			if (!this.validarSintaxisUsuario(c.getUser())) {
				respuesta.addProperty("error", "sintaxisUsuario");
			} else {
				if (this.validarNuevoUsuario(c)) {
					respuesta.addProperty("error", "userexist");
				} else {
					if (vu.validarNuevoEmail(c,this.getAll())) {
						respuesta.addProperty("error", "usuario_mail");
					} else {
						respuesta = vu.checkEmail(c.getEmail());
						if (respuesta.get("error").toString().equalsIgnoreCase("success")) {
							this.addUser(c);
						}
					}
				}
			}
		}
		return respuesta;
	}
	

	public boolean isStrongPassword(String passwd) {
	      String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
	      return (passwd.matches(pattern));
	}
	 
	public boolean validarSintaxisUsuario(String usuario) {

		boolean estadoUsuario = true;

		for (char ch : usuario.toCharArray()) {
			if (!Character.isDigit(ch)) {
				if (!Character.isLetter(ch)) {
					estadoUsuario = false;
					break;
					}
				} 
		}
		return estadoUsuario;
	}

//	public JsonObject validarCorreo(String email) {
//
//		String estado_email = null;
//		try {
//			estado_email = this.checkEmail(email);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		JsonObject correo = new JsonObject();
//
//		Gson g = new Gson();
//		correo = g.fromJson(estado_email, JsonObject.class);
//
//		JsonObject respuesta = new JsonObject();
//
//		if (correo.get("smtp_check").toString().equalsIgnoreCase("true")) {
//			respuesta.addProperty("error", "success");
//		} else {
//			respuesta.addProperty("error", correo.get("smtp_check").toString());
//		}
//
//		return respuesta;
//	}

	public Boolean userExist(Ciudadano ciud) {
		Ciudadano c = new Ciudadano();
		c = getById(ciud);
		if (c.getUser().equals(ciud.getUser()) && BCrypt.checkpw(ciud.getPassword(), c.getPassword())) {
			return true;
		} else
			return false;
	}

	public void correo(String receptor) {
		Properties props = new Properties();

		// Nombre del host de correo, es smtp.gmail.com para gmail
		props.setProperty("mail.smtp.host", "smtp.gmail.com");

		// TLS si esta disponible
		props.setProperty("mail.smtp.starttls.enable", "true");

		// Puerto de gmail para envio de correos
		props.setProperty("mail.smtp.port", "587");

		// Nombre del usuario
		props.setProperty("mail.smtp.user", "buccielias@gmail.com");

		// Si requiere o no usuario y password para conectarse.
		props.setProperty("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);

		// Para obtener un log de salida m�s extenso
		session.setDebug(true);

		MimeMessage message = new MimeMessage(session);

		// Quien envia el correo

		try {
			message.setFrom(new InternetAddress("buccielias@gmail.com"));

			// A quien va dirigido
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
			message.setSubject("Bienvenido");
			message.setContent("<h1 style='color:red'>Bienvenido<h1>", "text/html; charset=utf-8");
			Transport t = session.getTransport("smtp");

			// Aqui usuario y password de gmail
			t.connect("buccielias@gmail.com", "Bu4576063Cc2");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public JsonObject checkEmail(String email) throws Exception {
//
//		String url = "https://apilayer.net/api/check?access_key=" + apikey + "&email=" + email + "&smtp=1&format=1";
//
//		URL urlobj = new URL(url);
//
//		HttpURLConnection con = (HttpURLConnection) urlobj.openConnection();
//
//		// optional default is GET
//		con.setRequestMethod("GET");
//
//		// add request header
//		con.setRequestProperty("User-Agent", "Mozilla/17.0");
//
//		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//
//		while ((inputLine = in.readLine()) != null) {
//			response.append(inputLine);
//		}
//		in.close();
//
//		// print result
//		JsonObject correo = new JsonObject();
//
//		Gson g = new Gson();
//		correo = g.fromJson(response.toString(), JsonObject.class);
//
//		JsonObject respuesta = new JsonObject();
//
//		if (correo.get("smtp_check").toString().equalsIgnoreCase("true")) {
//			respuesta.addProperty("error", "success");
//		} else {
//			respuesta.addProperty("error", correo.get("smtp_check").toString());
//		}
//
//		return respuesta;

//	}

}