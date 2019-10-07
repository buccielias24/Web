package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import entidades.Viaje;

public class DataViaje {

	public void add(Viaje v) {
		PreparedStatement stmt= null;	
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into viaje(planetaOrigen,planetaDestino,fechaSalida,fechaLlegada,estadoViaje,IdNave) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,v.getOrigen().getIdPlaneta());
			stmt.setInt(2,v.getDestino().getIdPlaneta());
			stmt.setString(3, v.getSalida());
			stmt.setString(4, v.getLlegada());
			stmt.setBoolean(5, v.getEstado());
			stmt.setInt(6, v.getAstrobus().getIdNave());
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