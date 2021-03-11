package com.atm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtmLoader extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 

   {
		try
		{
			int amount=Integer.parseInt(req.getParameter("amount"));
			if(amount%100000==0) 
			{
				AtmMachine atmObject=new AtmMachine(amount);
				RequestDispatcher rd=req.getRequestDispatcher("/Home.html");
				rd.forward(req,res);			
		    }				
		   else 				   
			   res.sendRedirect("MoneyLoader.jsp");
		   
			
	    } catch (Exception e) {
		 res.sendRedirect("MoneyLoader.jsp");
	    }
	    	    	
   }


}