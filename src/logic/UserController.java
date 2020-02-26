package logic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import data.DataUser;
import entidades.Ciudadano;
import sun.misc.BASE64Encoder;

public class UserController {
	DataUser du;
	
	public UserController() {
		du=new DataUser();
	}
	
	public Ciudadano getById(Ciudadano ciud)
	{
		return du.getById(ciud);	
	}
	
	public void addUser(Ciudadano user, String pass2)
	{
			if (this.validarUsuario(user))
			{
				try {
					du.add(user);
					this.correo(user.getEmail());
					}catch(Exception e) {System.out.println("algun error");}	
			}else {
				System.out.println("usuario ya existe");
			}
			
	}
	
	public boolean validarUsuario(Ciudadano usuario)
	{
		boolean validar=true;
		ArrayList<Ciudadano> usuarios=this.getAll();
		for(Ciudadano user:usuarios)
		{
			if(user.getDgu()!=usuario.getDgu())
			{
				if(!user.getEmail().equals(usuario.getEmail()))
				{
					if(!user.getUser().equals(usuario.getUser()))
					{
					}else {validar=false;break;}
				}else {validar=false; break;}
			}else {validar=false; break;}
		
		}					
	return validar;
	}
	
	public ArrayList<Ciudadano> getAll()
	{
		return du.getAll();
	}

	// Completar al registrar y editar perfil poder subir foto
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
	
	public void correo(String receptor)
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
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
		message.setSubject("Bienvenido");
		message.setText("<h1>Desde ahora sera el señor thompson del lago del terror.</h1>");
	
		Transport t = session.getTransport("smtp");

		// Aqui usuario y password de gmail
		t.connect("buccielias@gmail.com","Bu4576063Cc2");
		t.sendMessage(message,message.getAllRecipients());
		t.close();
	}catch(Exception e) {
		e.printStackTrace();
	}}
			
	}
