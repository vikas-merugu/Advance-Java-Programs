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

@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        
        try {
            String proId = request.getParameter("proId");
            String updatedProName = request.getParameter("proName");
            String proPriceStr = request.getParameter("proPrice");
            String updatedProBrand = request.getParameter("proBrand");
            String updatedProMadeIn = request.getParameter("proMadeIn");
            String proMfgStr = request.getParameter("proMfg");
            String proExpStr = request.getParameter("proExp");

            // Check for null values and handle appropriately
            if (proId == null || updatedProName == null || proPriceStr == null || 
                updatedProBrand == null || updatedProMadeIn == null || proMfgStr == null || 
                proExpStr == null) {
                writer.println("One or more required parameters are missing.");
                return;
            }

            double updatedProPrice = Double.parseDouble(proPriceStr.trim());
            Date updatedProMfg = Date.valueOf(proMfgStr.trim());
            Date updatedProExp = Date.valueOf(proExpStr.trim());

            Product product = new Product();
            product.setProId(proId);
            product.setProName(updatedProName);
            product.setProPrice(updatedProPrice);
            product.setProBrand(updatedProBrand);
            product.setProMadeIn(updatedProMadeIn);
            product.setProMfg(updatedProMfg);
            product.setProExp(updatedProExp);

            Part newFilePart = request.getPart("newProImage");
            Part existingFilePart = request.getPart("existingImage");

            // Check for new image first
            if (newFilePart != null && newFilePart.getSize() > 0) {
                try (InputStream inputStream = newFilePart.getInputStream()) {
                    byte[] newImageData = IOUtils.toByteArray(inputStream);
                    product.setProImage(newImageData);
                }
            } else if (existingFilePart != null && existingFilePart.getSize() > 0) {
                try (InputStream inputStream = existingFilePart.getInputStream()) {
                    byte[] existingImage = IOUtils.toByteArray(inputStream);
                    product.setProImage(existingImage);
                }
            } else {
                writer.println("No image provided.");
                return;
            }

            ProductDao dao = new ProductDao();
            int result = dao.updateById(product);

            if (result == 1) {
                writer.println("Data update was successful.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
                dispatcher.include(request, response);
            } else {
                writer.println("Data update failed. Please check and try again.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("add-product.html");
                dispatcher.include(request, response);
            }
        } catch (NumberFormatException e) {
            writer.println("Invalid number format: " + e.getMessage());
        } catch (Exception e) {
            writer.println("An error occurred: " + e.getMessage());
        }
    }
}
