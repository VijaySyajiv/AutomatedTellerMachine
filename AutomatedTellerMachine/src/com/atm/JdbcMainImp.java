package com.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcMainImp implements JdbcMain {

	
	//this method is to check the authentication of the user
	public   AccountDetails logInVerification(int accountNumber,int pinNumber) throws SQLException 
	{
		try {
				Class.forName("com.mysql.jdbc.Driver"); 	
				Connection con=DriverManager.getConnection(url,userName,password);
				PreparedStatement st=con.prepareStatement("select * from accountdetails where accountNumber=?");
				st.setInt(1, accountNumber);
				ResultSet rs=st.executeQuery();
				rs.next();
				if(rs.getInt(3)==pinNumber) {
					System.out.println("crt");
					AccountDetails account=new AccountDetails(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
					con.close();
					System.out.println("logInVerification success");
					return account;
				}
				System.out.println("logInVerification null");
				return null;
		}
		catch(Exception e) {
			System.out.println("logInVerification exception "+e);
		return null;
		}
	}
				
		
		
		
	
	//this method is to check whether the input account number is right or wrong
	public  AccountDetails accountVerification(int accountNumber) throws SQLException 
	{		
	         try
	         {
	        	   System.out.println("accountVerification in" );
		        	Class.forName("com.mysql.jdbc.Driver");
		        	Connection con=DriverManager.getConnection(url,userName,password);
		 			PreparedStatement st=con.prepareStatement("select * from accountdetails where accountNumber=?");
		 			st.setInt(1, accountNumber);
		 			ResultSet rs=st.executeQuery();
		 			rs.next();
		 			AccountDetails account=new AccountDetails(rs.getInt(1),rs.getString(2),rs.getInt(4));
		 			con.close();
		 			System.out.println("accountVerification ot" );
		 			return account;
	 			
	 		}
	 		catch(Exception e)
	         {
	 			System.out.println("accountVerification e"+e );
	 			return null;
	 		}	
	}
	
	//this method is to update user account balance in database
	public void updateBalance(AccountDetails account) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,password);
			PreparedStatement st=con.prepareStatement("update accountdetails set accountBalance=? where accountNumber=?");  
			st.setInt(1, account.accountBalance);
			st.setInt(2,account.accountNumber); 
			st.executeUpdate();  
			System.out.println("updated");
			con.close();
		} catch (ClassNotFoundException e) {
			
			System.out.println(e);
		} 
		
	}
	
	//this method is to update transaction details in database for the online transaction
	public void updateOnlineTransaction(int accountNumber,AccountDetails userAccount,AccountDetails transferAccount,String type,int amount) throws SQLException
 {
		
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,userName,password);
				PreparedStatement st=con.prepareStatement("INSERT INTO transaction (accountNumber,accountNumberFrom,accountNumberTo,transactionType,transactionAmount) VALUES(?,?,?,?,?)");  
				st.setInt(1,accountNumber);
				st.setInt(2,userAccount.accountNumber); 
				st.setInt(3,transferAccount.accountNumber);
				st.setString(4,type);
				st.setInt(5, amount);
				st.executeUpdate();  
				con.close();
				System.out.println("updateOnlineTransaction suc");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} 
		
		
	}
	
	//this method is to update transaction details in database for the withdrawal
	public void updateWithdrawTransaction(int accountNumber,AccountDetails userAccount,String type,int amount) throws SQLException 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,password);
			PreparedStatement st=con.prepareStatement("INSERT INTO transaction (accountNumber,accountNumberFrom,transactionType,transactionAmount) VALUES(?,?,?,?)");  
			st.setInt(1,accountNumber);
			st.setInt(2,userAccount.accountNumber);
			st.setString(3,type);
			st.setInt(4, amount);
			st.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} 
		
	}
	
	
	public List<Transaction> statement(int userAccount) throws SQLException
	{
		List<Transaction> transaction=new ArrayList<Transaction>();
		try {
				
				Class.forName("com.mysql.jdbc.Driver"); 	
				Connection con=DriverManager.getConnection(url,userName,password);
				PreparedStatement st=con.prepareStatement("select * from transaction where accountNumber=? ",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				st.setInt(1, userAccount); 
				ResultSet rs=st.executeQuery();
				rs.afterLast();
				int temp=4;
				while(temp>=0 && rs.previous()) 
				{
					Transaction transactions=new Transaction(rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6));
					transaction.add(0,transactions);
				     temp--;
				}
				
	
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
				
			return transaction;  
    }
	
	public  List<AccountDetails> accountDetails () 
	    {
	    	List<AccountDetails> account=new ArrayList<AccountDetails>();
			try {
					
					Class.forName("com.mysql.jdbc.Driver"); 	
					Connection con=DriverManager.getConnection(url,userName,password);
					PreparedStatement st=con.prepareStatement("select * from accountdetails");
					ResultSet rs=st.executeQuery();
					
					
					while( rs.next()) 
					{
						AccountDetails accounts=new AccountDetails(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
						System.out.println(accounts);
						account.add(accounts);
					    
					}
					
		
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
					
				return account;
	    	
	    	
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
