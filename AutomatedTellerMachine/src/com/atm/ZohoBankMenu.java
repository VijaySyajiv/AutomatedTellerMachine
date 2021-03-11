package com.atm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ZohoBankMenu extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		try {
		String option =req.getParameter("menuOption");
		HttpSession session=req.getSession(); 
		session.setAttribute("menuOption", option);
		AccountDetails account=(AccountDetails)session.getAttribute("account");
		PrintWriter pr=res.getWriter();
		if(account!=null) {
				switch(option)
				{
					case "checkBalance":
						req.setAttribute("balance",account.accountBalance);
						RequestDispatcher rd=req.getRequestDispatcher("/BalanceDisplay.jsp");
						rd.forward(req,res);
						session.removeAttribute("account"); 
						session.removeAttribute("menuOption"); 
						
						break;
					case "withDraw":
						System.out.println("wdm");
						res.sendRedirect("WithdrawDisplay.html");
						break;
					case "transfer":
						res.sendRedirect("Transfer.html");
						break;
					case "miniStatement":
						res.sendRedirect("statement");
						
						break;
					default:
						System.out.println("5");
						break;
					
				}
			}
		else {
			res.sendRedirect("Home.html");
		}
		}
		catch(Exception e) {
			res.sendRedirect("Home.html");
		}

   }
}
