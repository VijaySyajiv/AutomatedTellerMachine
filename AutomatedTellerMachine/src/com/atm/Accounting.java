package com.atm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//accounts
public class Accounting extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		System.out.println("Accounting");
		HttpSession session=req.getSession(); 
		AccountDetails userAccount=(AccountDetails)session.getAttribute("account");
		
		String option=(String)session.getAttribute("menuOption");
		System.out.println("Accounting session");
		if(option.equals("transfer"))
		{
			try {
			AccountDetails transferAccount=(AccountDetails)session.getAttribute("transferAccount");
			int transferamount=(int)session.getAttribute("transferamount");
			userAccount.accountBalance-=transferamount;
			transferAccount.accountBalance+=transferamount;
			System.out.println("jdbc called");
			JdbcConnectivity.onlineTransferAccounting(res,userAccount,transferAccount);
			session.invalidate();
			}
			catch(Exception e) {
				
			}
			
			
		}
		
		else if(option.equals("withdarw"))
		{
			
		}
		
		
	}
}
