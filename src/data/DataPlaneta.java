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
}

	