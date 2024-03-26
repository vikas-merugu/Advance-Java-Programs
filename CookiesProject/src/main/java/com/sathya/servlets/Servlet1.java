package com.sathya.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the data
				String username=request.getParameter("username");
				String age=request.getParameter("age");
				
		//create the Cookies object
		Cookie cookie1=new Cookie("username",username);
		Cookie cookie2=new Cookie("age", age);
		
		//add the cookies into response object
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		
	}

}
