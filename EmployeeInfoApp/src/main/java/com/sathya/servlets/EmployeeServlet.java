package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int EmployeeId=Integer.parseInt(request.getParameter("Employee Id"));
		String EmployeeName=request.getParameter("Employee Name");
		double EmployeeBasicSalary=Double.parseDouble(request.getParameter("Employee Basic Salary"));
		
		//step2
		double HRA=0,DA=0,PF=0,GrossSalary;
		
		
		if(EmployeeBasicSalary>=50000)
		{
		HRA=EmployeeBasicSalary*0.3;
		DA=EmployeeBasicSalary*0.1;
		PF=EmployeeBasicSalary*0.06;
		}
		else if(EmployeeBasicSalary<50000&&EmployeeBasicSalary>25000)
		{
			HRA=EmployeeBasicSalary*0.2;
			DA=EmployeeBasicSalary*0.05;
			PF=EmployeeBasicSalary*0.03;
		}
		else
		{
			HRA=EmployeeBasicSalary*0.1;
			DA=EmployeeBasicSalary*0.03;
			PF=EmployeeBasicSalary*0.02;
		}
		GrossSalary=EmployeeBasicSalary+HRA+DA-PF;
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=green>");
		writer.println("<br><br>");
		writer.println("Employee Id="+EmployeeId);
		writer.println("<br><br>");
		writer.println("Employee name="+EmployeeName);
		writer.println("<br><br>");
		writer.println("Employee Basic Salary="+EmployeeBasicSalary);
		writer.println("<br><br>");
		writer.println("HRA="+HRA);
		writer.println("<br><br>");
		writer.println("DA="+DA);
		writer.println("<br><br>");
		writer.println("PF="+PF);
		writer.println("<br><br>");
		writer.println("Gross Salary="+GrossSalary);
		writer.println("<br><br>");
		writer.println("</body>");
		writer.println("</html>");
	}

	}


