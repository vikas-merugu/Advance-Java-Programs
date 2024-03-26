package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculaterServlet")
public class CalculaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//step1 read the data
		
		int Firstnumber=Integer.parseInt(request.getParameter("First Number"));
		int Secondnumber=Integer.parseInt(request.getParameter("Second Number"));
		String Operator=request.getParameter("operation");
		
		//step2 Process the data
		int result=0;
		 
		switch(Operator)
		{
			case "+" : result=Firstnumber+Secondnumber;
			break;
		
			case "-" : result=Firstnumber-Secondnumber;
			break;
			
			case "*" : result=Firstnumber*Secondnumber;
			break;
			
			case "/" : result=Firstnumber/Secondnumber;
			break;
			
			case "%" : result=Firstnumber%Secondnumber;
			break;
			
		}
		//Step3 Render the Response
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=orange>");
		writer.println("<h1><i>CALCULATED RESULT</i></h1>");
		writer.println("<b>First number=</b>"+Firstnumber);
		writer.println("<br><br>");
		writer.println("<b>Second Number=</b>"+Secondnumber);
		writer.println("<br><br>");
		writer.println("<b>RESULT</b>="+result);
		writer.println("<br><br>");
		writer.println("</body>");
		writer.println("</html>");
		
		
	}	
		
	}

	
	


