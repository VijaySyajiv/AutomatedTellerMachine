package com.atm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OnlineTransfer extends HttpServlet{
	
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
			
			try {
				    int accountNumber=Integer.parseInt(req.getParameter("accountNumber"));
					HttpSession session=req.getSession();	
					AccountDetails userAccount=(AccountDetails)session.getAttribute("account");
					if(userAccount!=null &&userAccount.accountNumber!=accountNumber)
					{
						System.out.println("OnlineTransfer fail");
						AccountDetails account=JdbcMainApi.accountVerifications(accountNumber);
						System.out.println("OnlineTransfer success");
						if(account!=null) 
						{							
							session.setAttribute("transferAccount", account);
							res.sendRedirect("TransferAmount.html");
					    }	
						else
							 res.sendRedirect("Transfer.jsp");
							
					}
					else
						res.sendRedirect("Transfer.jsp");
						
				} 
			catch (Exception e) {
				
				 res.sendRedirect("Transfer.jsp");
			}
			
			
	}
       

}
