package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//get the data
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		//Display total details
		HttpSession session=request.getSession(false);
		 response.setContentType("text/html");
         
         PrintWriter writer=response.getWriter();
        
         writer.println("<html>");
         writer.println("<body bgcolor='orange'>");
         writer.println("<pre style='color:red'>");
           writer.println("<h1><b>Registered Details</b></h1>");

          
           writer.println("username"+session.getAttribute("username"));
           writer.println("<br>");
           writer.println("age"+session.getAttribute("age"));
           writer.println("<br>");
           writer.println("qualification"+session.getAttribute("qualification"));
           writer.println("<br>");
           writer.println("designation"+session.getAttribute("designation"));
           writer.println("<br>");
           writer.println("user email"+email);
           writer.println("<br>");
           writer.println("user mobile"+mobile);
           writer.println("<br>");
           writer.println("</pre>");
           writer.println("</body>");
           writer.println("</html>");
             
	}

}
