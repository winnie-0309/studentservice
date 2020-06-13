package com.yanran.student.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;

public class DBO {
	static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static String username = "scott";
	static String password = "tiger";
	
	private static JdbcConnectionPool jdbcCP = null;
	static {
		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		String dbPath ="./config/test";
		jdbcCP = JdbcConnectionPool.create("jdbc:h2:" + dbPath, "sa", "");
        jdbcCP.setMaxConnections(50);
	}
	


	public static Connection getConnection() {
		Connection conn = null;
		try {
			//real is oracle 
			//conn = (DBO) DriverManager.getConnection(url, username, password);
			//just demo for h2
			conn = jdbcCP.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}