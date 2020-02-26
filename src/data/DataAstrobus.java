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
					a.setIdNave(rs.getInt("id"));
					a.setMarca(rs.getString("marca"));
					a.setCantAsientos(rs.getInt("cantAsientos"));
					a.setDistLimite(rs.getDouble("distLimite"));
					a.setDistService(rs.getDouble("distService"));
					a.setEstado(rs.getBoolean("estado"));
					a.setTiempoLibre(rs.getString("tiempoDesdeSinUso"));
					a.setFecha_alta(rs.getString("fecha_alta"));
					a.setFecha_baja(rs.getString("fecha_baja"));
					a.setMotivo(rs.getInt("motivo"));
					a.setComentario(rs.getString("comentario"));
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
					prepareStatement("select * from astrobus where id=?");
			stmt.setInt(1,a.getIdNave());
				rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				a1.setIdNave(rs.getInt("id"));
				a1.setMarca(rs.getString("marca"));
				a1.setCantAsientos(rs.getInt("cantAsientos"));
				a1.setDistLimite(rs.getDouble("distLimite"));
				a1.setDistService(rs.getDouble("distService"));
				a1.setTiempoLibre(rs.getString("tiempoDesdeSinUso"));
				a1.setEstado(rs.getBoolean("estado"));			
				a1.setFecha_alta(rs.getString("fecha_alta"));
				a1.setFecha_baja(rs.getString("fecha_baja"));
				a1.setMotivo(rs.getInt("motivo"));
				a1.setComentario(rs.getString("comentario"));			
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
	
	public void add(Astrobus a) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into astrobus(cantAsientos,distRecorrida,distLimite,distService,fechaAlta,estado) values(?,0,?,?,now(),true)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, a.getCantAsientos());
			stmt.setDouble(2, a.getDistLimite());
			stmt.setDouble(3, a.getDistService());
			stmt.executeUpdate();			
			keyResultSet=stmt.getGeneratedKeys();
			  if(keyResultSet!=null && keyResultSet.next()){
	                a.setIdNave(keyResultSet.getInt(1));}
	    	}catch (SQLException e) {
          e.printStackTrace();}	finally {
              try {
                  if(keyResultSet!=null)keyResultSet.close();
                  if(stmt!=null)stmt.close();
                  Conectar.getInstancia().releaseConn();
              } catch (SQLException e) {
              	e.printStackTrace();
              }
  		}
 } 	

	
//DAR DE BAJA ASTROBUS
	public void modify(Astrobus a) {
		PreparedStatement stmt= null;
		try {
			stmt=Conectar.getInstancia().getConn().prepareStatement("UPDATE astrobus SET estado=false,fecha_baja=now(),motivo='porque se hizo percha' where id=?");
			stmt.setInt(1, a.getIdNave());
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
	
	
