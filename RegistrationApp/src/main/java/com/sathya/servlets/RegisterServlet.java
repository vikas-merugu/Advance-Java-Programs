package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//read the data
	
String username=request.getParameter("username");
String password=request.getParameter("password");
Long mobile=Long.parseLong(request.getParameter("mobile"));
String email=request.getParameter("email");
String gender=request.getParameter("gender");
String dob=request.getParameter("dob");
String[] quals=request.getParameterValues("qualification");
String country=request.getParameter("country");
String[] Lang=request.getParameterValues("Languages");
String comments=request.getParameter("comments");

//process the data

String q=String.join(",", quals);
String l=String.join("-",Lang );

//render the response

response.setContentType("text/html");
PrintWriter writer=response.getWriter();
writer.println("<html>");
writer.println("<body>");
writer.println("<br>");
writer.println("Name="+username);
writer.println("<br>");
writer.println("Password="+password);
writer.println("<br>");
writer.println("Mobile="+mobile);
writer.println("<br>");
writer.println("Email="+email);
writer.println("<br>");
writer.println("Gender="+gender);
writer.println("<br>");
writer.println("DOB="+dob);
writer.println("<br>");
writer.println("Qualification="+q);
writer.println("<br>");
writer.println("Country="+country);
writer.println("<br>");
writer.println("Languages="+l);
writer.println("<br>");
writer.println("Comments="+comments);
writer.println("<br>");

writer.println("</body>");
writer.println("</html>");

}

	
	}


