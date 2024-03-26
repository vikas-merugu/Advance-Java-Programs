package com.sathya.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddProductServlet() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ProId=request.getParameter("proId");
		String ProName=request.getParameter("proName");
		double ProPrice=Double.parseDouble(request.getParameter("proPrice"));
		String ProBrand=request.getParameter("proBrand");
		String MadeIn=request.getParameter("proMadeIn");
		Date ProMfg=Date.valueOf(request.getParameter("proMfg"));
		Date ProExp=Date.valueOf(request.getParameter("proExp"));
		Part part=request.getPart("proImage");
		
		InputStream inputStream=part.getInputStream();
		
		//conversion of inputstream into byte
		byte[] proImage = IOUtils.toByteArray(inputStream);
		
	    
		
		Product product=new Product();
		product.setProId(ProId);
		product.setProName(ProName);
		product.setProPrice(ProPrice);																																																											
		product.setProBrand(ProBrand);
		product.setProMadeIn(MadeIn);
		product.setProMfg(ProMfg);
		product.setProExp(ProExp);
		product.setProImage(proImage);
		
		ProductDao pr=new ProductDao();
		int result=pr.SaveProduct(product);
		if(result==1) {
			request.setAttribute("saveResult", result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.setContentType("text/html");  
			PrintWriter writer=response.getWriter();
			writer.println("Data insertion Fail Check once"+result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
			dispatcher.include(request, response);
		}
		
		
	}

}
