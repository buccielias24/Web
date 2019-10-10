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
			rs= stmt.executeQuery("select idNave,cantAsientos,distLimite,distService,estado from astrobus");
			// ver con el profe si podemos traer el estado del planeta con un nombre con la funcion if() de sql
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Astrobus p=new Astrobus();
					p.setIdNave(rs.getInt("idNave"));
					p.setCantAsientos(rs.getInt("cantAsientos"));
					p.setDistLimite(rs.getDouble("distLimite"));
					p.setDistService(rs.getDouble("distService"));
					p.setEstado(rs.getBoolean("estadoPlaneta"));
					// dr.setRoles(p);
					astrobuses.add(p);
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
		Astrobus p=null;	
		try {
			stmt= Conectar.getInstancia().getConn().
					prepareStatement("select idNave,cantAsientos,distLimite,distService,estado from astrobus where idNave=?");
			stmt.setInt(1,a.getIdNave());
				rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				Astrobus a1=new Astrobus();
				a1.setIdNave(rs.getInt("idNave"));
				a1.setCantAsientos(rs.getInt("cantAsientos"));
				a1.setDistLimite(rs.getDouble("distLimite"));
				a1.setDistService(rs.getDouble("distService"));
				a1.setEstado(rs.getBoolean("estadoPlaneta"));			
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
		return p;
	}
	
	public void add(Astrobus a) {
		PreparedStatement stmt= null;
		
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into astrobus(cantAsientos,distRecorrida,distLimite,distService,tiempoDesdeSinUso,estado) values(?,0,?,?,now(),true)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, a.getCantAsientos());
			stmt.setDouble(3, a.getDistLimite());
			stmt.setDouble(4, a.getDistService());
			stmt.executeUpdate();			
	    	}catch (SQLException e) {
            e.printStackTrace();} 	 
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
	
	
//ACTUALIZAR total distancia recorrida
	public void updateAstroviaje(int id,double dr) {
			
		PreparedStatement stmt= null;
		//ResultSet keyResultSet=null;
		try {
			
			stmt=Conectar.getInstancia().getConn().prepareStatement(
							
							"UPDATE astrobus set distRecorrida+="+dr+" where IdNave="+id+";"
							+"UPDATE astrobus set tiempoDesdeSinUso=now() where IdNave="+id+";"+"UPDATE astrobus set estado=true where IdNave="+id+";",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
            } catch (SQLException e) {
            e.printStackTrace();
		} 	
    }
	
}


