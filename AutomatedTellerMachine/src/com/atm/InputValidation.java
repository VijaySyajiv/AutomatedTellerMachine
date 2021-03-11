package com.atm;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InputValidation extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		try {
				HttpSession session=req.getSession(); 
				if(((AccountDetails)session.getAttribute("account"))!=null)
						{
							int amount=Integer.parseInt(req.getParameter("amount"));
							session.setAttribute("transferamount",amount);
							String option=(String)session.getAttribute("menuOption");
							if(option.equals("transfer")) 
							{
								if((amount<=10000)&&(amount>=1000)) 
									res.sendRedirect("balance");
								
								else 
									res.sendRedirect("TransferAmount.jsp");
								
							}
							else if(option.equals("withDraw")) 
							{
								System.out.println("IV");
								if((amount<=10000)&&(amount>=100)&&(amount%100==0)) 
									res.sendRedirect("balance");
								
								else 
									res.sendRedirect("WithdrawDisplay.jsp");
								
							}
							else
								res.sendRedirect("Home.html");
								
							
						}
				else 
					res.sendRedirect("Home.html");
				
		}
		catch(Exception e) {
			res.sendRedirect("Home.html");
		}

		
		
	}
	
}