	
package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")

public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public HelloWorldServlet() {
        // TODO Auto-generated constructor stub
    }
    				
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<h1>Hello world");
		writer.println("<h2>Welcome to sathya");
		writer.println("<h3>Welcome to Adavance Java");
		writer.println("</html>");
		}

	
	
	}


