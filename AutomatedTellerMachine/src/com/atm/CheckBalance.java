package com.atm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//balance
public class CheckBalance extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		try {
				HttpSession session=req.getSession(); 
				AccountDetails account=(AccountDetails)session.getAttribute("account");
				int amount=(int)session.getAttribute("transferamount");
				if(userBalanceValidate(account,amount)) 
				{
					System.out.println("CheckBalance");
					res.sendRedirect("accounts");
					
				}
				else {
					res.sendRedirect("BalanceEndPage.html");
				}
		}
		catch(Exception e) {
			res.sendRedirect("ThankYouPage.html");
		}
		
	}
	public boolean userBalanceValidate(AccountDetails account,int amount) {
		return ((account.accountBalance-100)<amount?false:true);
		
	}
}
