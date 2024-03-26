package com.sathya.jdbc;
import java.sql.*;
public class Dbclient {

	public static void main(String[] args) {
		EmployeeDao ed=new EmployeeDao();
		int res1=ed.save(new Employee(101,"vikas",116.00));
		System.out.println("Data inseted Successfully"+res1);
		
		int res2=ed.save(new Employee(102,"hemanth",108.0));
		System.out.println("Data inserted Successfully"+res2);
		
		Employee emp=ed.findById(101);
		System.out.println(emp);
		
		
		
		
		
		
		
		
		
			}

}
