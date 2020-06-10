package test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBO {
	static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	static String username="scott";
	static String password="tiger";
	static{
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
				e.printStackTrace();
}
	}
	public static DBO getConnection() {
DBO conn=null;
try {
	conn=(DBO) DriverManager.getConnection(url,username,password);
} catch (SQLException e) {
				e.printStackTrace();
}
	return conn;
	}
}