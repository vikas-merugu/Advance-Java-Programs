package com.sathya.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ProId=request.getParameter("proId");
		String updatedProName=request.getParameter("proName");
		double updatedProPrice=Double.parseDouble(request.getParameter("proPrice"));
		String updatedProBrand=request.getParameter("proBrand");
		String updatedproMadeIn=request.getParameter("proMadeIn");
		Date updatedProMfg=Date.valueOf(request.getParameter("proMfg"));
		Date updatedProExp=Date.valueOf(request.getParameter("proExp"));
		
		Product product = new Product();
		product.setProId(ProId);
		product.setProName(updatedProName);
		product.setProPrice(updatedProPrice);
		product.setProBrand(updatedProBrand);
		product.setProMadeIn(updatedproMadeIn);
		product.setProMfg(updatedProMfg);
		product.setProExp(updatedProExp);
		
		Part filePart = request.getPart("newProImage");
		if(filePart != null && filePart.getSize() > 0) {
			InputStream inputStream = filePart.getInputStream();
			byte[] newImageData = IOUtils.toByteArray(inputStream);
			product.setProImage(newImageData);
			
			
		}else {
			Part file = request.getPart("existingImage");
			InputStream inputStream = filePart.getInputStream();
			byte[] existingImage = IOUtils.toByteArray(inputStream);
			product.setProImage(existingImage);
			
		}
		ProductDao dao = new ProductDao();
		int result = dao.updateById(product);
		
		if(result==1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
			dispatcher.include(request, response);
		}
		else
		{ response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("Data Updation fail check once");
		RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
		dispatcher.include(request, response);
		}
		
		
		
		
		
	}

}
