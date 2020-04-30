
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
					v.setSalida(rs.getString("salida"));
					v.setLlegada(rs.getString("llegada"));
					p1.setId(rs.getInt("origen"));
					v.setOrigen(pc.getById(p1));
					p2.setId(rs.getInt("destino"));
					v.setDestino(pc.getById(p2));
					a.setIdNave(rs.getInt("id_astrobus")); 
					v.setAstrobus(ac.getById(a));
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
							"insert into astrobus_planeta(origen,destino,fechaSalida,fechaLlegada,IdAstrobus) values(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,v.getOrigen().getId());
			stmt.setInt(2,v.getDestino().getId());
			stmt.setString(3, v.getSalida());
			stmt.setString(4, v.getLlegada());
		    stmt.setInt(5, v.getAstrobus().getIdNave());
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
