package com.atm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartUP extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		try {
			String startUpOption=req.getParameter("startUpOption");
			
			if(startUpOption.equals("moneyLoader")) {
				res.sendRedirect("MoneyLoader.html");
			}
			else if(startUpOption.equals("accountDetails")) {
				res.sendRedirect("AccountDisplay.jsp");
			}
			else if(startUpOption.equals("atmOperation")){
				res.sendRedirect("Home.html");
			}
		}
		catch(Exception e) {
			res.sendRedirect("AtmStartUp.jsp");
		}
		
	}

}

