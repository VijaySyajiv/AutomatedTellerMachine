package com.atm;
import java.io.PrintWriter;
import java.lang.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;


public class JdbcConnectivity  {
	
		static String url="jdbc:mysql://localhost:3306/zohobank";;
		static String userName="root";
		static String password="";
		//method for Authenticate the user
		public static AccountDetails logInVerification(HttpServletResponse res,int accountNumber,int pinNumber) throws Exception 
		{
			
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(url,userName,password);
			
			try {
				PreparedStatement st=con.prepareStatement("select * from accountdetails where accountNumber=?");
				st.setInt(1, accountNumber);
				ResultSet rs=st.executeQuery();
				rs.next();
				if(rs.getInt(3)==pinNumber) {
					System.out.println("crt");
					AccountDetails account=new AccountDetails(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
					return account;					
				}
				else {
					res.sendRedirect("Home.jsp");
				}
			}
			catch(Exception e) {
				System.out.println("exception jdbc");
				 res.sendRedirect("Home.jsp");
			}
			
			return null;
			
		}
		public static AccountDetails accountVerification(HttpServletResponse res,int accountNumber) throws Exception 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(url,userName,password);
			
			try {
				PreparedStatement st=con.prepareStatement("select * from accountdetails where accountNumber=?");
				st.setInt(1, accountNumber);
				ResultSet rs=st.executeQuery();
				rs.next();
				AccountDetails account=new AccountDetails(rs.getInt(1),rs.getString(2),rs.getInt(4));
				return account;
				
			}
			catch(Exception e) {
				 res.sendRedirect("Transfer.jsp");
			}			
			return null;	
		}
		
		
		public static void onlineTransferAccounting(HttpServletResponse res,AccountDetails userAccount,AccountDetails transferAccount) throws Exception 
		{
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con=DriverManager.getConnection(url,userName,password);
				
				try {
					updateBalance(con,userAccount);
					updateBalance(con,transferAccount);
					 res.sendRedirect("ThankYouPage.html");
				}
				catch(Exception e) {
					 res.sendRedirect("Transfer.jsp");
				}			
				
		}
		public static void updateBalance(Connection con,AccountDetails account) throws SQLException {
			
				PreparedStatement st=con.prepareStatement("update accountdetails set accountBalance=? where accountNumber=?");  
				st.setInt(1, account.accountBalance);
				st.setInt(2,account.accountNumber); 
				st.executeUpdate();  
				System.out.println("updated");
				
					  
		}
	
}
