package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Planeta;
import entidades.Resenia;

public class DataResenia {

	public ArrayList<Resenia> getAll(Planeta p){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Resenia r=null;	
		ArrayList<Resenia> reseñas=new ArrayList<>();
		
		try {
			stmt= Conectar.getInstancia().getConn().
					prepareStatement("select * from resenia where idPlaneta=?");
				stmt.setInt(1,p.getIdPlaneta());
				rs=stmt.executeQuery();
				if(rs!=null) {
					while(rs.next()) {		
					r=new Resenia();
					r.setComentario(rs.getString("comentario"));
					r.setDgu(rs.getInt("idUsuario"));
					r.setFecha(rs.getString("fecha"));
					r.setIdPlaneta(p.getIdPlaneta());
					r.setPuntaje(rs.getFloat("puntaje"));
					reseñas.add(r);
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
		}	return reseñas;
	}
}


