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
		ArrayList<Planeta> pers= new ArrayList<>();
		
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
					
					pers.add(p);
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
		
		
		return pers;
	}
}
	