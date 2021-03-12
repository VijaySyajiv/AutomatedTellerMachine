package com.atm;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Statement extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		try {
			    HttpSession session=req.getSession(); 
			    AccountDetails account=(AccountDetails)session.getAttribute("account");
			    List<Transaction> transaction=JdbcMainApi.statements(account.accountNumber);
				System.out.println("Statement succesfull");
				
				req.setAttribute("transaction", transaction);
				RequestDispatcher rd=req.getRequestDispatcher("/MiniStatement.jsp");
				rd.forward(req,res);
					
		    }
		catch(Exception e) {
			res.sendRedirect("Home.html");
		}
		
	}
	
}