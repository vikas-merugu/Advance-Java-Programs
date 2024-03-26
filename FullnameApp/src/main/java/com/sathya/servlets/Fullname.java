package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fullname
 */
@WebServlet("/Fullname")
public class Fullname extends HttpServlet {												
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String Firstname=request.getParameter("First name");
		String Middlename=request.getParameter("Middle name");
		String Lastname=request.getParameter("Last name");

		
		String status;
		status=Firstname+Middlename+Lastname;
				PrintWriter Writer=response.getWriter();
		response.setContentType("text/html");
		
		
		Writer.println("<html>");
		Writer.println("<body bgcolor=orange>");
		
		Writer.println("<h1>FULL NAME</h1>"+status);
		Writer.println("</body>");
	    Writer.println("</html>");
		
		
		
	    																																																																																																																																																																																																																										


	
	}

}
