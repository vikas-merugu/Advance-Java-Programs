package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//step:1 Load the driver
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driverloaded Successfully");
		
		//step:2 create the connection
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","developer");
		
		System.out.println("Connection Created Successfully");
		
		//step:3 
		
		
		
		//step:4 close the connection
		
connection.close();
System.out.println("Connection Closed Successfully");


	}

}
 