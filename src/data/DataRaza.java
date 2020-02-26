package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Planeta;
import entidades.Raza;

public class DataRaza {
	
	public ArrayList<Raza> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Raza> razas= new ArrayList<>();		
		try {
			stmt= Conectar.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from raza");
			if(rs!=null) {
				while(rs.next()) {
					Raza r=new Raza();
					r.setIdRaza(rs.getInt("IdRaza"));
					r.setNombre(rs.getString("nombreRaza"));
					r.setPeligrosidad(rs.getInt("nivelPeligro"));
					razas.add(r);
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
		return razas;
	}
	
	public Raza getById(int ID){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Raza r=new Raza();	
		try {
			stmt= Conectar.getInstancia().getConn().
					prepareStatement("select * from raza where IdRaza=?");
				stmt.setInt(1,ID);
				rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
					r.setIdRaza(rs.getInt("IdRaza"));
					r.setNombre(rs.getString("nombreRaza"));
					r.setPeligrosidad(rs.getInt("nivelPeligro"));
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
		}	
		return r;
	}
	
}
