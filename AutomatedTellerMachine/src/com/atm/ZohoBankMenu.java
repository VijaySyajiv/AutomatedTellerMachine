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
		switch(option)
		{
			case "checkBalance":
				res.sendRedirect("BalanceDisplay.jsp");
//				RequestDispatcher rd=req.getRequestDispatcher("/Home.html");
//				rd.forward(req,res);
				
				break;
			case "withDraw":
				res.sendRedirect("WithdrawDisplay.html");
				break;
			case "transfer":
				res.sendRedirect("Transfer.html");
				break;
			case "miniStatement":
				System.out.println("4");
				break;
			default:
				System.out.println("5");
				break;
			
		}
		}
		catch(Exception e) {
			res.sendRedirect("Home.jsp");
		}

   }
}
