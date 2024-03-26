package com.sathya.jdbc2;

import java.sql.*;

public class PDConnection {
	public  static Connection Connection() {
		// this method can be create Connection and return Connection
		Connection con=null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","developer");	
				}
				catch(ClassNotFoundException|SQLException e) {
					e.printStackTrace();
				}
		return con;
	}}