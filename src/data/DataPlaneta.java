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
		ResultSet keyResultSet=null;
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into planeta(nombrePlaneta, coordenada, estadoPlaneta) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getNombrePlaneta());
			stmt.setString(2, p.getCoordenada());
			stmt.setBoolean(3, p.getEstado());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdPlaneta((keyResultSet.getInt(1)));
            }

			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                Conectar.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
    }

	
}

	