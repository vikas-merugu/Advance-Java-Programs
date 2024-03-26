package com.sathya.jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDao  {
	public int save(Employee emp) {

		//declare the resources
		Connection c=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			//get the connection
			c=DBconnection.createConnection();
			//creat ps object
			ps = c.prepareStatement("insert into emp values(?,?,?)");			
			//read the data from emp object
			ps.setInt(1, emp.getEmpid());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			count=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
				
		}
		return count;
	}
	public Employee findById(int empid) {
		Employee employee=null;
		try(Connection c=DBconnection.createConnection();
		PreparedStatement ps=c.prepareStatement("select * from emp where empid=?")){
			ps.setInt(1, empid);
			ResultSet resultSet=ps.executeQuery();
			
			if(resultSet.next()) {
				employee =new Employee();
				employee.setEmpid(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setSalary(resultSet.getDouble(3));
			}
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		return employee;
	}
	
public int deleteById(int empid) {
	int dcount=0;
	try(Connection c=DBconnection.createConnection();PreparedStatement ps=c.prepareStatement("delete from emp where salary>?")){
		ps.setInt(1, empid);
		dcount=ps.executeUpdate();
	}
	catch(SQLException s) {
		s.printStackTrace();
	}
	return dcount;
}
public int deleteBySalary(int empsalary) {
	int scount=0;
	try(Connection c=DBconnection.createConnection();PreparedStatement ps=c.prepareStatement("delete from emp where salary>?")){
		ps.setInt(1, empsalary);
		scount=ps.executeUpdate();
	}
	catch(SQLException s) {
		s.printStackTrace();
	}
	return scount;

}
}

	


