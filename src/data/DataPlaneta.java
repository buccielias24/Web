package data;
//orig
import entidades.*;
import java.sql.*;
import java.util.ArrayList;

public class DataPlaneta {
	
	public ArrayList<Planeta> getAll(){
		//DataRol dr=new DataRol();
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Planeta> planetas= new ArrayList<>();
		
		try {
			stmt= Conectar.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idPlaneta,nombrePlaneta,coordenada,estadoPlaneta from planeta");
			// ver con el profe si podemos traer el estado del planeta con un nombre con la funcion if() de sql
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Planeta p=new Planeta();
					p.setIdPlaneta(rs.getInt("idPlaneta"));
					p.setNombrePlaneta(rs.getString("nombrePlaneta"));
					p.setCoordenada(rs.getString("coordenada"));
					p.setEstado(rs.getBoolean("estadoPlaneta"));
					// dr.setRoles(p);
					planetas.add(p);
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
		
		
		return planetas;
	}
	
	public void add(Planeta p) {
		PreparedStatement stmt= null;
		
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into planeta(idPlaneta,nombrePlaneta, coordenada, estadoPlaneta) values(?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, p.getIdPlaneta());
			stmt.setString(2, p.getNombrePlaneta());
			stmt.setString(3, p.getCoordenada());
			stmt.setBoolean(4, p.getEstado());
			stmt.executeUpdate();			
	    	}catch (SQLException e) {
            e.printStackTrace();} 	
    }

//DELETE	
	public void delete(int id) {
		PreparedStatement stmt= null;
		//ResultSet keyResultSet=null;
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"UPDATE planeta set estadoPlaneta = '"+0+"'Where idPlaneta="+id+";",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();			
            } catch (SQLException e) {
            e.printStackTrace();
		} 	
    }
	
	public ArrayList<Planeta> getById(int id){
		//DataRol dr=new DataRol();
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Planeta> planetas= new ArrayList<>();
		
		try {
			stmt= Conectar.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idPlaneta,nombrePlaneta,coordenada,estadoPlaneta from planeta where idPlaneta='"+id+"'");
			// ver con el profe si podemos traer el estado del planeta con un nombre con la funcion if() de sql
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Planeta p=new Planeta();
					p.setIdPlaneta(rs.getInt("idPlaneta"));
					p.setNombrePlaneta(rs.getString("nombrePlaneta"));
					p.setCoordenada(rs.getString("coordenada"));
					p.setEstado(rs.getBoolean("estadoPlaneta"));
					// dr.setRoles(p);
					planetas.add(p);
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
		
		
		return planetas;
	}
	
	public void modify(int id, String nombre, String coordenada) {
		PreparedStatement stmt= null;
		//ResultSet keyResultSet=null;
		try {
			String query=null;
			if (nombre=="" && coordenada!="") {
			query="UPDATE planeta set coordenada= '"+coordenada+"' Where idPlaneta="+id+";";
			}
			else if(coordenada=="" & nombre!="")
			{
			query="UPDATE planeta set nombrePlaneta= '"+nombre+"' Where idPlaneta="+id+";";	
			}
			else if(coordenada!="" && nombre!="")
			{
			query="UPDATE planeta set nombrePlaneta= '"+nombre+"', coordenada= '"+coordenada+"' Where idPlaneta="+id+";";	
			}
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();			
            } catch (SQLException e) {
            System.out.println("No ingreso ningun dato");
		} 	
    }
}

	