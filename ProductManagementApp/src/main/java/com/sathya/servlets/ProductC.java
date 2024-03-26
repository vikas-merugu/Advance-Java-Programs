package com.sathya.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductC {
	public  static Connection createConnection() {
		// this method can be create Connection and return Connection
		Connection c=null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","developer");
					
				}
				catch(ClassNotFoundException |SQLException e) {
					e.printStackTrace();
				}
		return c;	


	}
}
