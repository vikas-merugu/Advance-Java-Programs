package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NumberlistServlet")
public class NumberlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
 //  step1: get the data from client
		
		int f=Integer.parseInt( request.getParameter("Start Number"));
		int s=Integer.parseInt( request.getParameter("End Number"));
    String opp=request.getParameter("operation");
	     
	     //  step2 : process the data
    
             StringBuffer a=new StringBuffer();
                  ArrayList<Integer> e=new ArrayList<Integer>();
                   int i;
             switch(opp) {
	           
	           
	           case "Even":  
	        	               for(i=f;i<=s;i++)
	        	               {
	        	            	    if(i%2==0)
	        	            	    {
	        	            	    	a=a.append(i+" ");
	        	            	    	e.add(i);
	        	            	    }
	        	            	    		
	        	               }
	        	               break;
	                           

	           case "Odd":  for(i=f;i<=s;i++)
                                {
           	                       if(i%2!=0)
           	                          {
           	                            	a=a.append(i+" ");
           	                                	e.add(i);
           	                            }
           	    		
                                 }
                                 break;
              
	                       

	                        
                                 
	           case "Prime":    
	        	               for(i=f;i<=s;i++)
                               {
	        	            	   int count=0;
	        	                  for(int j=2;j<=i/2;j++)
	        	                  {
	        	                	    if(i%j==0)
	        	                	    {
	        	                	    	count=1;
	        	                	    	break;
	        	                	    }
	        	                	  
	        	                  }
	        	                    if(count==0)
	        	                    {
	        	                     	a=a.append(i+" ");
   	                                	e.add(i);
   	                           
	        	                    	
	        	                    }
                               }
  	                  
	                        break;
	                        

	           case "Perfect": for(i=f;i<=s;i++)
                           {
            	                int sum=0;
                            for(int j=1;j<=i/2;j++)
                                  {
                	                  if(i%j==0)
                	                     {
                	                      	sum=sum+j;
                	    	                   
                	                      }
                	  
                                  }
                              if(sum==i)
                                    {
                                     a=a.append(i+" ");
                                  	e.add(i);
                  
                    	
                                      }
                              }
        
	                        break;

	           case "Strong":  
	        	      int k;
	        	      int fact,sum,temp,rem;
	        	    for( k=f;k<=s;k++)
	        	    {
	        	    	       temp=k;
	        	              
	        	                sum=0;
	        	                
	        	      for( ;temp>0;temp=temp/10)

                         {
                             rem=temp%10;
                       
                               if(rem==0)
                                 fact=1;
                             else
                                 {    
                            	       fact=1;
                                    for(i =1;i<=rem;i++)
                                       {
                                           fact=fact*i;
                                 
                                         }
                                 }
                                    sum=sum+fact;
                            }
                         if(sum==k)
                         {
                             a=a.append(k+" ");
                               e.add(k);
                         }
	        	    }

                    
                           break;
	           
	           
	           
	        	    
             }

	 // Render the response to the client
   	      
             response.setContentType("text/html");
	         
	            PrintWriter writer=response.getWriter();
	            writer.println(" <html>");
	            writer.println("<body bgcolor='orange'> ");
	              writer.println("<h1><b>Calculation Details</b></h1>");

	              writer.println("The Result is:"+e);
	              writer.println("</body>");
	              writer.println("</html>");
	                
     


			
			}
			
			
		}
		
		
	

	
	


