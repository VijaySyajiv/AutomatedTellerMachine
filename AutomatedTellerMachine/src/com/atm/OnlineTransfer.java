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
					if(((AccountDetails)session.getAttribute("account"))!=null &&
							(((AccountDetails)session.getAttribute("account")).accountNumber!=accountNumber))
					{
						
						AccountDetails account=JdbcConnectivity.accountVerification(res,accountNumber);
						if(account!=null) {							
							session.setAttribute("transferAccount", account);
							res.sendRedirect("TransferAmount.html");
					    }	
//						else
							// res.sendRedirect("Transfer.jsp");
							
					}
					else
						res.sendRedirect("Transfer.jsp");
						
				} 
			catch (Exception e) {
				
				 res.sendRedirect("Transfer.jsp");
			}
			
			
	}
       

}
