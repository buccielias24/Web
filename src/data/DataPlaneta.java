package data;

import entidades.*;

import java.sql.*;
import java.util.ArrayList;

public class DataPlaneta {
	
	public ArrayList<Planeta> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Planeta> planetas= new ArrayList<>();		
		try {
			stmt= Conectar.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from planetas");
			if(rs!=null) {
				while(rs.next()) {
					Planeta p=new Planeta();
					p.setIdPlaneta(rs.getInt("id"));
					p.setNombrePlaneta(rs.getString("nombre"));
					p.setCoordenadaX(rs.getInt("coordenadaX"));
					p.setCoordenadaY(rs.getInt("coordenadaY"));
					p.setEstado(rs.getBoolean("estado"));
					p.setMotivo(rs.getInt("motivo_baja"));
					p.setFecha_alta("fecha_alta");
					p.setFecha_baja("fecha_baja");
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
				e.printStackTrace();}
		}		
		return planetas;
	}
	
	public void add(Planeta p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into planetas(nombre, coordenadaX,coordenadaY, estado,puntaje,motivo_baja,fecha_alta,fecha_baja) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getNombrePlaneta());
			stmt.setInt(2, p.getCoordenadaX());
			stmt.setInt(3, p.getCoordenadaY());
			stmt.setBoolean(4, p.getEstado());
			stmt.setInt(5, p.getMotivo());
			stmt.setString(6, p.getFecha_alta());
			stmt.setString(7, p.getFecha_baja());
			stmt.executeUpdate();	
			keyResultSet=stmt.getGeneratedKeys();
			  if(keyResultSet!=null && keyResultSet.next()){
	                p.setIdPlaneta(keyResultSet.getInt(1));}
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
	
	public void delete(Planeta p) { 
		PreparedStatement stmt= null;
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"UPDATE planetas set estado = false Where id=?",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, p.getIdPlaneta());
			stmt.executeUpdate();			
            } catch (SQLException e) {
            e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) {stmt.close();}
				Conectar.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
    }
	
	public Planeta getById(Planeta pla){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Planeta p=null;	
		try {
			stmt= Conectar.getInstancia().getConn().
					prepareStatement("select * from planetas where id=?");
				stmt.setInt(1,pla.getIdPlaneta());
				rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
					p=new Planeta();
					p.setIdPlaneta(rs.getInt("id"));
					p.setNombrePlaneta(rs.getString("nombre"));
					p.setCoordenadaX(rs.getInt("coordenadaX"));
					p.setCoordenadaY(rs.getInt("coordenadaY"));
					p.setEstado(rs.getBoolean("estado"));			
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
	
	public void modify(Planeta pla) {
		PreparedStatement stmt= null;
		try {
			stmt=Conectar.getInstancia().getConn().prepareStatement("UPDATE PLANETAS SET nombre=?,estado=? where id=?");
			stmt.setString(1,pla.getNombrePlaneta());
			stmt.setBoolean(3,pla.getEstado());
			stmt.setInt(4,pla.getIdPlaneta());
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


	