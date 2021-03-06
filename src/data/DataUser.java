package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Ciudadano;

public class DataUser {
//seria getByUser
	public Ciudadano getById(Ciudadano ciud){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Ciudadano c=null;	
		try {
			stmt= Conectar.getInstancia().getConn().
					prepareStatement("select nombre,apellido,dgu,usuario,password,rol from usuarios where usuario=? or dgu=? ");
				stmt.setString(1,ciud.getUser());
				stmt.setInt(2, ciud.getDgu());
				rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
					c=new Ciudadano();
					c.setNombre(rs.getString("nombre"));
					c.setApellido(rs.getString("apellido"));
					c.setDgu(rs.getInt("dgu"));	
					c.setUser(rs.getString("usuario"));
					c.setPassword(rs.getString("password"));
					c.setRol(rs.getInt("rol"));
			
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				Conectar.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	return c;
	}
}

