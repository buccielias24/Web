package data;

import java.sql.*;

public class Conectar {
	private static Conectar instancia;
	
	private String driver="com.mysql.jdbc.Driver";
	private String host="node51985-env-8234297.jelastic.saveincloud.net";
	private String localhost="localhost";
	private String port="3306";
	private String user="root";
	private String password="3uEy1obLkw";
	private String localpassword="root";
	private String db="astrobuses";
	private int conectados=0;
	private Connection conn=null;
	
	private Conectar() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Conectar getInstancia() {
		if (instancia == null) {
			instancia = new Conectar();
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:mysql://"+localhost+":"+port+"/"+db+"?useSSL=false", user, localpassword);
				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}