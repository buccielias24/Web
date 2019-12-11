package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Ciudadano;
import entidades.Planeta;
import entidades.Resenia;
import logic.PlanetaControler;
import logic.UserController;

public class DataResenia {


	PlanetaControler pc=new PlanetaControler();
	UserController uc=new UserController();
	
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
					Ciudadano c=new Ciudadano();
					Planeta pl=new Planeta();
						
					r=new Resenia();
					r.setComentario(rs.getString("comentario"));		
					c.setDgu(rs.getInt("idUsuario"));
					c=uc.getById(c);
					r.setUsuario(c);
					pl.setIdPlaneta(rs.getInt("idPlaneta"));
					pl=pc.getById(pl);
					r.setPlaneta(pl);
					r.setFecha(rs.getString("fecha"));
					r.setPuntaje(rs.getInt("puntaje"));
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
	
	public void add(Resenia r) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into resenia(fecha,comentario,puntaje,idPlaneta,idUsuario) values(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1,r.getFecha());
			stmt.setString(2, r.getComentario());
			stmt.setInt(3, r.getPuntaje());
			stmt.setInt(4, r.getPlaneta().getIdPlaneta());
			stmt.setInt(5, r.getUsuario().getDgu());
			stmt.executeUpdate();	
			keyResultSet=stmt.getGeneratedKeys();
			  if(keyResultSet!=null && keyResultSet.next()){
				  	Planeta p=new Planeta();
				  	p.setIdPlaneta(keyResultSet.getInt(4));
				  	r.setPlaneta(p);
				  	Ciudadano ciud=new Ciudadano();
				  	ciud.setDgu(keyResultSet.getInt(5));				  	
	                r.setFecha(keyResultSet.getString(1));}
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
	
	public void modify(Resenia res) {
		PreparedStatement stmt= null;
		try {
			stmt=Conectar.getInstancia().getConn().prepareStatement("UPDATE resenia SET fecha=?,comentario=?,puntaje=?,idPlaneta=?,idUsuario=? where id=?");
			stmt.setString(1,res.getFecha());
			stmt.setString(2,res.getComentario());
			stmt.setInt(3,res.getPuntaje());
			stmt.setInt(4,res.getPlaneta().getIdPlaneta());
			stmt.setInt(5,res.getUsuario().getDgu());
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
	
	public Resenia getByIds(Planeta p,Ciudadano c){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Resenia r=null;
		try {
			stmt= Conectar.getInstancia().getConn().
					prepareStatement("select * from resenia where idPlaneta=? and idUsuario=?");
				stmt.setInt(1,p.getIdPlaneta());
				stmt.setInt(2,c.getDgu());
				rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
					p.setIdPlaneta(rs.getInt("idPlaneta"));					
					r=new Resenia();
				    r.setPlaneta(p);					
				    r.setUsuario(c);
					r.setFecha(rs.getString("fecha"));
					r.setPuntaje(rs.getInt("puntaje"));
					r.setComentario(rs.getString("comentario"));
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
		return r;
	}
}


