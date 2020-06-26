package data;

import java.sql.Date;
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
	
	public ArrayList<Resenia> getAll(){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Resenia r=null;
		ArrayList<Resenia> resenias=new ArrayList<>();
		
		try {
			stmt= Conectar.getInstancia().getConn().
					prepareStatement("select * from resenia");
				rs=stmt.executeQuery();
				if(rs!=null) {
					while(rs.next()) {
					Ciudadano c=new Ciudadano();
					Planeta pl=new Planeta();
						
					r=new Resenia();
					r.setComentario(rs.getString("comentario"));		
					c.setDgu(rs.getInt("dgu"));
					c=uc.getById(c);
					r.setUsuario(c);
					pl.setId(rs.getInt("id_planeta"));
					pl=pc.getById(pl);
					r.setPlaneta(pl);
					r.setFecha(rs.getDate("fecha"));
					r.setPuntaje(rs.getInt("puntaje"));
					resenias.add(r);
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
		}	return resenias;
	}
	
	public void add(Resenia r) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into resenia(fecha,comentario,puntaje,idPlaneta,idUsuario) values(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setDate(1, (Date)r.getFecha());
			stmt.setString(2, r.getComentario());
			stmt.setInt(3, r.getPuntaje());
			stmt.setInt(4, r.getPlaneta().getId());
			stmt.setInt(5, r.getUsuario().getDgu());
			stmt.executeUpdate();	
			keyResultSet=stmt.getGeneratedKeys();
			  if(keyResultSet!=null && keyResultSet.next()){
				  	Planeta p=new Planeta();
				  	p.setId(keyResultSet.getInt(4));
				  	r.setPlaneta(p);
				  	Ciudadano ciud=new Ciudadano();
				  	ciud.setDgu(keyResultSet.getInt(5));				  	
	                }
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
			stmt.setDate(1,(Date) res.getFecha());
			stmt.setString(2,res.getComentario());
			stmt.setInt(3,res.getPuntaje());
			stmt.setInt(4,res.getPlaneta().getId());
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
	
	public ArrayList<Resenia> getOne(Planeta p){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Resenia r=null;
		ArrayList<Resenia> resenias=new ArrayList<>();
		try {
			stmt= Conectar.getInstancia().getConn().
					prepareStatement("select * from resenia where id_planeta=?");
				stmt.setInt(1,p.getId());
				rs=stmt.executeQuery();
				if(rs!=null) {
					while(rs.next()) {
					Ciudadano c=new Ciudadano();
					Planeta pl=new Planeta();
						
					r=new Resenia();
					r.setComentario(rs.getString("comentario"));		
					c.setDgu(rs.getInt("dgu"));
					c=uc.getById(c);
					r.setUsuario(c);
					pl.setId(rs.getInt("id_planeta"));
					pl=pc.getById(pl);
					r.setPlaneta(pl);
					r.setFecha(rs.getDate("fecha"));
					r.setPuntaje(rs.getInt("puntaje"));
					resenias.add(r);
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
		return resenias;
	}	
}


