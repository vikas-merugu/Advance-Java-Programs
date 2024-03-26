package com.sathya.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginformservlet
 */
@WebServlet("/Loginservlet")
public class Loginformservlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		String status;
		if(username.equals("Sathya") && password.equals("Sathya@123"))
		{
			status="Login Successfull...";
		}
		else
		{
			status="Login Failure...";
		}
		PrintWriter Writer=response.getWriter();
		response.setContentType("text/html");
		
		Writer.println("<html>");
		Writer.println("<body bgcolor=orange>");
		
		Writer.println("<h1>Login Status...</h1>"+status);
		Writer.println("</body>");
	    Writer.println("</html>");
		
		
		
	    																																																																																																																																																																																																																										
	}	
	}


