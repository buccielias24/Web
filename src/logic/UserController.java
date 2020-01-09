package logic;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
	
	public void correo()
	{
		Properties props = new Properties();

		// Nombre del host de correo, es smtp.gmail.com para gmail
		props.setProperty("mail.smtp.host", "smtp.gmail.com");

		// TLS si está disponible
		props.setProperty("mail.smtp.starttls.enable", "true");

		// Puerto de gmail para envio de correos
		props.setProperty("mail.smtp.port","587");

		// Nombre del usuario
		props.setProperty("mail.smtp.user", "buccielias@gmail.com");

		// Si requiere o no usuario y password para conectarse.
		props.setProperty("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);

		// Para obtener un log de salida más extenso
		session.setDebug(true);

		MimeMessage message = new MimeMessage(session);

		// Quien envia el correo
		
		try {	message.setFrom(new InternetAddress("buccielias@gmail.com"));
	
		// A quien va dirigido
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("buccielias@gmail.com"));
		message.setSubject("Asunto del mensaje");
		message.setText("Texto del mensaje");
	
		Transport t = session.getTransport("smtp");

		// Aqui usuario y password de gmail
		t.connect("buccielias@gmail.com","Bu4576063Cc2");
		t.sendMessage(message,message.getAllRecipients());
		System.out.println("Llega aca");
		t.close();
	}catch(Exception e) {
		e.printStackTrace();
	}}
			
	}
