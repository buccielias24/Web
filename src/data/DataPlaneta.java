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
			rs= stmt.executeQuery("select * from planeta");
			if(rs!=null) {
				while(rs.next()) {
					Planeta p=new Planeta();
					p.setId(rs.getInt("id_planeta"));
					p.setNombre(rs.getString("nombre"));
					p.setCoordenadaX(rs.getInt("coordenadaX"));
					p.setCoordenadaY(rs.getInt("coordenadaY"));
					p.setEstado(rs.getBoolean("estado"));
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
	
	public boolean add(Planeta p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=Conectar.getInstancia().getConn().
					prepareStatement(
							"insert into planeta(nombre, coordenadaX,coordenadaY, estado) values(?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getCoordenadaX());
			stmt.setInt(3, p.getCoordenadaY());
			stmt.setBoolean(4, p.getEstado());
			stmt.executeUpdate();	
			keyResultSet=stmt.getGeneratedKeys();
			  if(keyResultSet!=null && keyResultSet.next()){
	                p.setId(keyResultSet.getInt(1));}
			  		return true;	
	    	}catch (SQLException e) {
            e.printStackTrace();
            return false;}	finally {
                try {
                    if(keyResultSet!=null)keyResultSet.close();
                    if(stmt!=null)stmt.close();
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
					prepareStatement("select * from planeta where id_planeta=?");
				stmt.setInt(1,pla.getId());
				rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
					p=new Planeta();
					p.setId(rs.getInt("id_planeta"));
					p.setNombre(rs.getString("nombre"));
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
			stmt=Conectar.getInstancia().getConn().prepareStatement("UPDATE PLANETA SET nombre=?,coordenadaX=?,coordenadaY=?,estado=? where id_planeta=?");
			stmt.setString(1,pla.getNombre());
			stmt.setInt(2, pla.getCoordenadaX());
			stmt.setInt(3, pla.getCoordenadaY());
			stmt.setBoolean(4, pla.getEstado());
			stmt.setInt(5,pla.getId());
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
	
	public void baja(Planeta pla) {
		PreparedStatement stmt= null;
		try {
			stmt=Conectar.getInstancia().getConn().prepareStatement("UPDATE PLANETA SET estado=false,motivo_baja=? where id_planeta=?");
			stmt.setInt(1, pla.getMotivo());
			stmt.setInt(2,pla.getId());
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


	