package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proId=request.getParameter("proId");
		ProductDao pe=new ProductDao();
		int dcount=ProductDao.deleteById(proId);
		
		
		if(dcount==1) {
			request.setAttribute("deleteResult", dcount);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("deleteResult", dcount);
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Data Deletion Failed"+dcount);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		
		}

	}
}

