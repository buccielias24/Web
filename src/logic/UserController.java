package logic;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import data.DataUser;
import entidades.Ciudadano;

public class UserController {
	
	private DataUser du;
	
	public UserController() {
		du=new DataUser();
	}
	
	public Ciudadano getById(Ciudadano ciud)
	{
		return du.getById(ciud);	
	}
	
	public ArrayList<Ciudadano> getAll()
	{
		return du.getAll();
	}
	
	public void addUser(Ciudadano user) {
		
		if(this.validarUsuario(user)){				
			 user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
             user.setRol(0);
             du.add(user);
             this.correo(user.getEmail());
             }
		else{
        	 System.out.println("Usuario ya existe");}		
	}
	
	public boolean validarUsuario(Ciudadano usuario)
	{
		boolean validar=false;
		ArrayList<Ciudadano> usuarios=this.getAll();
		for(Ciudadano user:usuarios)
		{
			if(user.getDgu()!=usuario.getDgu())
			{
				if(!user.getEmail().equals(usuario.getEmail()))
				{
					if(!user.getUser().equals(usuario.getUser()))
					{
					  validar=true;
					}else {validar=false;break;}
				}else {validar=false; break;}
			}else {validar=false; break;}		
		}					
		return validar;
	}
		
	public Boolean userExist(Ciudadano ciud)
	{
		Ciudadano c=new Ciudadano();
	    c=getById(ciud);   
		if(c.getUser().equals(ciud.getUser())&& BCrypt.checkpw(ciud.getPassword(),c.getPassword()))
	    { 
	    	return true;
	    }
	    else
	    	return false;			
	}
	
	public void correo(String receptor)
	{
		Properties props = new Properties();

		// Nombre del host de correo, es smtp.gmail.com para gmail
		props.setProperty("mail.smtp.host", "ssl://smtp.gmail.com");

		// TLS si esta disponible
		props.setProperty("mail.smtp.starttls.enable", "true");
		
		// Puerto de gmail para envio de correos
		props.setProperty("mail.smtp.port","465");

		// Nombre del usuario
		props.setProperty("mail.smtp.user", "buccielias@gmail.com");

		// Si requiere o no usuario y password para conectarse.
		props.setProperty("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);

		// Para obtener un log de salida m�s extenso
		session.setDebug(true);

		MimeMessage message = new MimeMessage(session);

		// Quien envia el correo
		
		try {	message.setFrom(new InternetAddress("buccielias@gmail.com"));
	
		// A quien va dirigido
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
		message.setSubject("Bienvenido");
		message.setContent("<h1 style='color:red'>Bienvenido<h1>", "text/html; charset=utf-8");
		Transport t = session.getTransport("smtp");

		// Aqui usuario y password de gmail
		t.connect("buccielias@gmail.com","Bu4576063Cc2");
		t.sendMessage(message,message.getAllRecipients());
		t.close();
		}catch(Exception e) {
		e.printStackTrace();
		}
	}		
	
 }