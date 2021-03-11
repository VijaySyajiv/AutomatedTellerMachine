package com.atm;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				List<AccountDetails> accounts=JdbcMainApi.accountDetailss();
				System.out.println(accounts.get(0).toString());
				HttpSession session=req.getSession();
				session.setAttribute("bankAccount",accounts );
				
				RequestDispatcher rd=req.getRequestDispatcher("/AccountDisplay.jsp");
				rd.forward(req,res);			
		    }				
		   else 				   
			   res.sendRedirect("MoneyLoader.jsp");
			System.out.println(" loader fail");
			
	    } catch (Exception e) {
	    	System.out.println(e+" loader ");
		 res.sendRedirect("MoneyLoader.jsp");
	    }
	    	    	
   }


}