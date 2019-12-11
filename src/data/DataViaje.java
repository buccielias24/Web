
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Astrobus;
import entidades.Planeta;
import entidades.Viaje;

public class DataViaje {


	DataAstrobus da=new DataAstrobus();
	
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
					v.setSalida(rs.getString("fechaSalida"));
					v.setLlegada(rs.getString("fechaLlegada"));
					v.setEstado(rs.getBoolean("estadoViaje"));
					p1.setIdPlaneta(rs.getInt("origen"));
					v.setOrigen(p1);
					p2.setIdPlaneta(rs.getInt("destino"));
					v.setDestino(p2);
					v.setDistancia(rs.getDouble("distancia"));
				    a.setIdNave(rs.getInt("astrobus")); 
					v.setAstrobus(da.getById(a));
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
			DataPlaneta dp=new DataPlaneta();
			Planeta origen=null;
			Planeta destino=null;
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
						v.setIdViaje(rs.getInt("id"));
						v.setOrigen(dp.getById(origen));
						v.setDestino(dp.getById(destino));
						v.setEstado(rs.getBoolean("estado"));			
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
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into viaje(origen,destino,fechaSalida,fechaLlegada,estadoViaje,distancia,astrobus) values(?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,v.getOrigen().getIdPlaneta());
			stmt.setInt(2,v.getDestino().getIdPlaneta());
			stmt.setString(3, v.getSalida());
			stmt.setString(4, v.getLlegada());
			stmt.setBoolean(5, v.getEstado());
			stmt.setDouble(6, v.getDistancia());
            stmt.setInt(7, v.getAstrobus().getIdNave());
			stmt.executeUpdate();			
	    	}catch (SQLException e) {
            e.printStackTrace();}finally {
    			try {
    				if(stmt!=null) {stmt.close();}
    				Conectar.getInstancia().releaseConn();
    				} catch (SQLException e) {
    				e.printStackTrace();}
    				}
			}
	
}
