package com.atm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
			JdbcMainApi.onlineTransferAccounting(userAccount, transferAccount, transferamount);
			session.removeAttribute("account");
			res.sendRedirect("ThankYouPage.html");
			}
			catch(Exception e) {
				
			}
			
			
		}
		
		else if(option.equals("withDraw"))
		{
			try {
			
					int transferamount=(int)session.getAttribute("transferamount");
					if(transferamount<=AtmMachine.atmBalance && AtmMachine.denomininations(transferamount))
					{
						
						userAccount.accountBalance-=transferamount;
						AtmMachine.atmBalance-=transferamount;
						System.out.println("ATM Balance "+AtmMachine.atmBalance);
						JdbcMainApi.withdrawAccounting(userAccount, transferamount);
						session.removeAttribute("account");
						req.setAttribute("hundredRupees",AtmMachine.hn);
						req.setAttribute("fiveHundredRupees",AtmMachine.fn);
						req.setAttribute("thousandRupees",AtmMachine.tn);
						RequestDispatcher rd=req.getRequestDispatcher("/Denomininations.jsp");
						rd.forward(req,res);
						
						
			         }
					else
					{
						System.out.println(AtmMachine.atmBalance);
						session.removeAttribute("account");
						res.sendRedirect("AtmMachineBalanceNull.html");
					}
			}
			catch(Exception e) {
				
			}

		}
		
		
	}
}
