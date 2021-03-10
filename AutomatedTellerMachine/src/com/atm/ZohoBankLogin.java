package com.atm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ZohoBankLogin extends HttpServlet{
	
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
			
			try {
					int accountNumber=Integer.parseInt(req.getParameter("accountNumber"));
					int pinNumber=Integer.parseInt(req.getParameter("pinNumber"));
					PrintWriter pr=res.getWriter();
				    AtmMachine atmObject=new AtmMachine(100000);
					AccountDetails account=JdbcConnectivity.logInVerification(res,accountNumber,pinNumber);
					if(account!=null) {

						HttpSession session=req.getSession();	
						session.setAttribute("account", account);
						RequestDispatcher rd=req.getRequestDispatcher("/Menu.html");
						rd.forward(req,res);
				
				    }
					
				   else {
//					   res.sendRedirect("Home.jsp");
				   }
					
					
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				 res.sendRedirect("Home.jsp");
			}
			
			
			System.out.println("Runed");
	}
       

}
