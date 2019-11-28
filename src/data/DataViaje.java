package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Planeta;
import entidades.Viaje;

public class DataViaje {

	
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
					v.setIdViaje(rs.getInt("idViaje"));
					v.setSalida(rs.getString("fechaSalida"));
					v.setLlegada(rs.getString("fechaLlegada"));
					v.setEstado(rs.getBoolean("estadoViaje"));
					p1.setIdPlaneta(rs.getInt("origen"));
					v.setOrigen(p1);
					p2.setIdPlaneta(rs.getInt("destino"));
					v.setDestino(p2);					
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
	
	public void add(Viaje v) {
		PreparedStatement stmt= null;	
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into viaje(origen,destino,fechaSalida,fechaLlegada,estadoViaje) values(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,v.getOrigen().getIdPlaneta());
			stmt.setInt(2,v.getDestino().getIdPlaneta());
			stmt.setString(3, v.getSalida());
			stmt.setString(4, v.getLlegada());
			stmt.setBoolean(5, v.getEstado());
		//	stmt.setInt(6, v.getAstrobus().getIdNave());
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