package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step1 read the data
		
		int ProductId=Integer.parseInt(request.getParameter("ProductId"));
		String ProductName=request.getParameter("ProductName");
		double ProductPrice=Double.parseDouble(request.getParameter("ProductPrice"));
		int Productquantity=Integer.parseInt(request.getParameter("Productquantity"));
		
		//step2 Process the data
		double discount,Totalbill,netprice;
		Totalbill=ProductPrice * Productquantity;
		
		if( Totalbill<=1000) {
			discount=0;
		}
		else if(Totalbill>100 && Totalbill<=5000) {
			discount=Totalbill*0.5;
		}
		else if(Totalbill>5000 && Totalbill<=10000) {
			discount=Totalbill*0.1;
		}
		else {
			discount=Totalbill*0.15;
		}
			netprice=Totalbill-discount;
		//step3 Render the response
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("<br><br>");
		writer.println("Product id="+ProductId);
		writer.println("<br><br>");
		writer.println("Product name="+ProductName);
		writer.println("<br><br>");
		writer.println("Product price="+ProductPrice);
		writer.println("<br><br>");
		writer.println("Product Quantity="+Productquantity);
		writer.println("<br><br>");
		writer.println("Product totalbill.....="+Totalbill);
		writer.println("<br><br>");
		writer.println("Product discount.....="+discount);
		writer.println("<br><br>");
		writer.println("Product netprice.....="+netprice);
		writer.println("<br><br>");
		writer.println("</html>");
		
		
	}
		
}
