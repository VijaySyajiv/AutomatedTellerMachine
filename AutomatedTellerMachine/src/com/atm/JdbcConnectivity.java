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
					con.close();
					return account;					
				}
				else {
					con.close();
					res.sendRedirect("Home.jsp");
				}
			}
			catch(Exception e) {
				System.out.println("exception jdbc");
				con.close();
				 res.sendRedirect("Home.jsp");
			}
			con.close();
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
				con.close();
				return account;
				
			}
			catch(Exception e) {
				con.close();
				 res.sendRedirect("Transfer.jsp");
			}	
			con.close();
			return null;	
		}
		
		
		public static void onlineTransferAccounting(HttpServletResponse res,AccountDetails userAccount,AccountDetails transferAccount,int amount) throws Exception 
		{
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con=DriverManager.getConnection(url,userName,password);
				
				try {
					updateBalance(con,userAccount);
					updateBalance(con,transferAccount);
					updateOnlineTransaction(con,userAccount.accountNumber,userAccount,transferAccount,"Debit",amount);
					updateOnlineTransaction(con,transferAccount.accountNumber,userAccount,transferAccount,"Credit",amount);
					con.close();
					 res.sendRedirect("ThankYouPage.html");
				}
				catch(Exception e) {
					con.close();
					 res.sendRedirect("Home.jsp");
				}			
				
		}
		public static void withdrawAccounting(AccountDetails userAccount,int amount) throws Exception 
		{
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con=DriverManager.getConnection(url,userName,password);
				updateBalance(con,userAccount);
				updateWithdrawTransaction(con,userAccount.accountNumber,userAccount,"Credit",amount);
				con.close();
				
		}
		public static void updateBalance(Connection con,AccountDetails account) throws SQLException 
		{
			
				PreparedStatement st=con.prepareStatement("update accountdetails set accountBalance=? where accountNumber=?");  
				st.setInt(1, account.accountBalance);
				st.setInt(2,account.accountNumber); 
				st.executeUpdate();  
				System.out.println("updated");					  
		}
		
		public static void updateOnlineTransaction(Connection con,int accountNumber,AccountDetails userAccount,AccountDetails transferAccount,String type,int amount) throws SQLException
		{
			System.out.println("id");
			PreparedStatement st=con.prepareStatement("INSERT INTO transaction (accountNumber,accountNumberFrom,accountNumberTo,transactionType,transactionAmount) VALUES(?,?,?,?,?)");  
			st.setInt(1,accountNumber);
			st.setInt(2,userAccount.accountNumber); 
			st.setInt(3,transferAccount.accountNumber);
			st.setString(4,type);
			st.setInt(5, amount);
			st.executeUpdate();  
//			ResultSet rs=st.getGeneratedKeys();
			int id=0;
//			if(rs.next())
//				 id=rs.getInt(1);
			System.out.println("updated trans");
			
				  
	    }
		public static void updateWithdrawTransaction(Connection con,int accountNumber,AccountDetails userAccount,String type,int amount) throws SQLException
		{
			System.out.println("id");
			PreparedStatement st=con.prepareStatement("INSERT INTO transaction (accountNumber,accountNumberFrom,transactionType,transactionAmount) VALUES(?,?,?,?)");  
			st.setInt(1,accountNumber);
			st.setInt(2,userAccount.accountNumber);
			st.setString(3,type);
			st.setInt(4, amount);
			st.executeUpdate();
			System.out.println("updated trans");
			
				  
	    }
		public static Transaction[] statement(int userAccount) throws SQLException
		{
			Transaction[] transaction=new Transaction[5];
			try {
					
					Connection con=DriverManager.getConnection(url,userName,password);
					PreparedStatement st=con.prepareStatement("select * from transaction where accountNumber=? ",ResultSet.TYPE_SCROLL_INSENSITIVE,
		                    ResultSet.CONCUR_UPDATABLE);
					st.setInt(1, userAccount); 
					ResultSet rs=st.executeQuery();
					rs.afterLast();
		//			rs.previous();
					int temp=4;
					while(temp>=0 && rs.previous()) {
						transaction[temp]=new Transaction(rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6));
					     temp--;
					}
					
		
			}
			catch(Exception e) {
				System.out.println(e);
			}
					
				return transaction;  
	    }
		
	
}
