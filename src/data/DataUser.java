package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Ciudadano;
import entidades.Planeta;

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
	
	public ArrayList<Ciudadano> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Ciudadano> usuarios= new ArrayList<>();		
		try {
			stmt= Conectar.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from usuarios");
			if(rs!=null) {
				while(rs.next()) {
					Ciudadano c=new Ciudadano();
					c.setDgu(rs.getInt("dgu"));
					c.setNombre(rs.getString("nombre"));
					c.setApellido(rs.getString("apellido"));
					c.setPassword(rs.getString("password"));
					c.setUser(rs.getString("usuario"));
					c.setRol(rs.getInt("rol"));
					c.setEmail(rs.getString("email"));
					usuarios.add(c);
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				Conectar.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();}
		}		
		return usuarios;
	}
	
	public void add(Ciudadano user) {
		PreparedStatement stmt= null;
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into usuarios(dgu, nombre,apellido, usuario,password,email,rol) values(?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, user.getDgu());
			stmt.setString(2, user.getNombre());
			stmt.setString(3, user.getApellido());
			stmt.setString(4, user.getUser());
			stmt.setString(5, user.getPassword());
			stmt.setString(6, user.getEmail());
			stmt.setInt(7, user.getRol());
			stmt.executeUpdate();	
			}catch (SQLException e) {
            e.printStackTrace();}	finally {
                try {
                    if(stmt!=null)stmt.close();
                    Conectar.getInstancia().releaseConn();
                } catch (SQLException e) {
                	e.printStackTrace();
                }
    		}
   } 	
}

