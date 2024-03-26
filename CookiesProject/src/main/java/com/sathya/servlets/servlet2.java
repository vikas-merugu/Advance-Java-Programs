package com.sathya.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//get the data
				String qualification=request.getParameter("qualification");
				String designation=request.getParameter("designation");
				
				//create the session object
				HttpSession session=request.getSession(false);
				
				//Store the data into Session object
				session.setAttribute("qualification", qualification);
				session.setAttribute("designation", designation);
				
				//give next form to client
				RequestDispatcher dispatcher=request.getRequestDispatcher("Form3.html");
				dispatcher.forward(request, response);
		
	}

}
