package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Astrobus;
import entidades.Planeta;

public class DataAstrobus {
	public ArrayList<Astrobus> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Astrobus> astrobuses= new ArrayList<>();
		
		try {
			stmt= Conectar.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from astrobus");
			if(rs!=null) {
				while(rs.next()) {
					Astrobus a=new Astrobus();
					a.setIdNave(rs.getInt("IdAstrobus"));
					a.setCantAsientos(rs.getInt("cantAsientos"));
					a.setDistLimite(rs.getDouble("distLimite"));
					a.setDistService(rs.getDouble("distService"));
					a.setEstado(rs.getBoolean("estado"));
					a.setFecha_alta(rs.getString("fecha_alta"));
					a.setFecha_baja(rs.getString("fecha_baja"));
					a.setMotivo(rs.getInt("motivo"));
					astrobuses.add(a);
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
				e.printStackTrace();
			}
		}		
		return astrobuses;
	}
	
	public Astrobus getById(Astrobus a){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Astrobus a1=new Astrobus();
		try {
			stmt= Conectar.getInstancia().getConn().
					prepareStatement("select * from astrobus where IdAstrobus=?");
			stmt.setInt(1,a.getIdNave());
				rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				a1.setIdNave(rs.getInt("IdAstrobus"));
				a1.setCantAsientos(rs.getInt("cantAsientos"));
				a1.setDistLimite(rs.getDouble("distLimite"));
				a1.setDistService(rs.getDouble("distService"));
				a1.setEstado(rs.getBoolean("estado"));			
				a1.setFecha_alta(rs.getString("fecha_alta"));
				a1.setFecha_baja(rs.getString("fecha_baja"));
				a1.setMotivo(rs.getInt("motivo"));			
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
		return a1;
	}
	
		
//DAR DE BAJA ASTROBUS
	public void modify(Astrobus a) {
		PreparedStatement stmt= null;
		try {
			stmt=Conectar.getInstancia().getConn().prepareStatement("UPDATE astrobus SET estado=? where IdAstrobus=?");
			stmt.setBoolean(1, a.getEstado());
			stmt.setInt(2, a.getIdNave());
			stmt.executeUpdate();			
            } catch (SQLException e) {
            e.printStackTrace();}finally {
			try {
				if(stmt!=null) {stmt.close();}
				Conectar.getInstancia().releaseConn();
				} catch (SQLException e) {
				e.printStackTrace();} 	
				}
		}
}
	
	
