package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Astrobus;

public class DataAstrobus {
	public ArrayList<Astrobus> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Astrobus> astrobuses= new ArrayList<>();
		
		try {
			stmt= Conectar.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from astrobus");
			// ver con el profe si podemos traer el estado del planeta con un nombre con la funcion if() de sql
			//intencionalmente no se recupera la password
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
					// dr.setRoles(p);
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
				a1.setEstado(rs.getBoolean("estado"));			
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
							"insert into astrobus(marca,cantAsientos,distRecorrida,distLimite,distService,tiempoDesdeSinUso,estado) values(?,?,0,?,?,now(),true)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, a.getMarca());
			stmt.setInt(2, a.getCantAsientos());
			stmt.setDouble(3, a.getDistLimite());
			stmt.setDouble(4, a.getDistService());
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
	public void update(int id) {
		PreparedStatement stmt= null;
		//ResultSet keyResultSet=null;
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"UPDATE astrobus set estado= '"+0+"'Where idNave="+id+";",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();			
            } catch (SQLException e) {
            e.printStackTrace();
		} 	
    }
	
	
}


