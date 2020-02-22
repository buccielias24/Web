
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Astrobus;
import entidades.Planeta;
import entidades.Viaje;
import logic.AstrobusController;
import logic.PlanetaControler;

public class DataViaje {


	PlanetaControler pc=new PlanetaControler();
	AstrobusController ac=new AstrobusController();
	
	
	
	public ArrayList<Viaje> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Viaje> viajes= new ArrayList<>();		
		try {
			stmt= Conectar.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from viaje");
			if(rs!=null) {
				while(rs.next()) {
					Viaje v=new Viaje();
					Planeta p1=new Planeta();
					Planeta p2=new Planeta();
					Astrobus a=new Astrobus();
					v.setIdViaje(rs.getInt("idViaje"));
					v.setSalida(rs.getString("salida"));
					v.setLlegada(rs.getString("llegada"));
					v.setEstado(rs.getInt("estadoViaje"));
					p1.setIdPlaneta(rs.getInt("origen"));
					v.setOrigen(pc.getById(p1));
					p2.setIdPlaneta(rs.getInt("destino"));
					v.setDestino(pc.getById(p2));
					v.setDistancia(rs.getDouble("distancia"));
				    a.setIdNave(rs.getInt("astrobus")); 
					v.setAstrobus(ac.getById(a));
					v.setMotivo(rs.getInt("motivo"));
					viajes.add(v);
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
		return viajes;
	}
	public Viaje getById(Viaje via) {
			Planeta origen=null;
			Planeta destino=null;
			Astrobus a=new Astrobus();
			PreparedStatement stmt=null;
			ResultSet rs=null;
			Viaje v=null;	
			
			try {
				stmt= Conectar.getInstancia().getConn().
						prepareStatement("select * from viajes where id=?");
					stmt.setInt(1,via.getIdViaje());
					rs=stmt.executeQuery();

				if(rs!=null && rs.next()) {
						origen.setIdPlaneta(rs.getInt("origen"));
						destino.setIdPlaneta(rs.getInt("destino"));
						v=new Viaje();
						v.setSalida(rs.getString("fechaSalida"));
						v.setLlegada(rs.getString("fechaLlegada"));
						v.setEstado(rs.getInt("estadoViaje"));
						origen.setIdPlaneta(rs.getInt("origen"));
						v.setOrigen(pc.getById(origen));
						destino.setIdPlaneta(rs.getInt("destino"));
						v.setDestino(pc.getById(destino));
						v.setDistancia(rs.getDouble("distancia"));
					    a.setIdNave(rs.getInt("astrobus")); 
						v.setAstrobus(ac.getById(a));
						v.setMotivo(rs.getInt("motivo"));
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
			return v;
		}


	
	public void add(Viaje v) {
		PreparedStatement stmt= null;	
		ResultSet keyResultSet=null;
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into viaje(origen,destino,salida,llegada,estadoViaje,distancia,motivo,astrobus) values(?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,v.getOrigen().getIdPlaneta());
			stmt.setInt(2,v.getDestino().getIdPlaneta());
			stmt.setString(3, v.getSalida());
			stmt.setString(4, v.getLlegada());
			stmt.setInt(5, v.getEstado());
			stmt.setDouble(6, v.getDistancia());
            stmt.setInt(7,v.getMotivo());
            stmt.setInt(8, v.getAstrobus().getIdNave());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			  if(keyResultSet!=null && keyResultSet.next()){
	                v.setIdViaje((keyResultSet.getInt(1)));}
	    	}catch (SQLException e) {
            e.printStackTrace();}finally {
    			try {
    				if(stmt!=null) {stmt.close();}
    				Conectar.getInstancia().releaseConn();
    				} catch (SQLException e) {
    				e.printStackTrace();}
    				}
			}
	 
	public void modify(Viaje v) {
		PreparedStatement stmt= null;
		try {
			stmt=Conectar.getInstancia().getConn().prepareStatement("UPDATE viaje SET fechaSalida=?,fechaLlegada=?,estadoViaje=?,origen=?,destino=?,distancia=?,astrobus=?,motivo=? where idViaje=?");
			stmt.setString(1,v.getSalida());
			stmt.setString(2,v.getLlegada());
			stmt.setInt(3,v.getEstado());
			stmt.setInt(4,v.getOrigen().getIdPlaneta());
			stmt.setInt(5, v.getDestino().getIdPlaneta());
			stmt.setDouble(6, v.getDistancia());
			stmt.setInt(7, v.getAstrobus().getIdNave());
			stmt.setInt(8, v.getMotivo());
			stmt.setInt(9,v.getIdViaje());
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
