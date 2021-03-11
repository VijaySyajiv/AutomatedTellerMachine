package com.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

public class JdbcMainApi extends JdbcMainImp 
{          
	 
	public static AccountDetails logInVerifications(int accountNumber, int pinNumber) throws SQLException 
	{
		
		JdbcMain jdbc=new JdbcMainImp();
		AccountDetails account=jdbc.logInVerification(accountNumber, pinNumber);
		System.out.println(account);
		if(account!=null)
			return account;
		else
			return null;
		
	}
	public static AccountDetails accountVerifications(int accountNumber) throws SQLException, ClassNotFoundException 
	{
			
			JdbcMain jdbc=new JdbcMainImp();
			AccountDetails account=jdbc.accountVerification(accountNumber);
			if(account!=null)
				return account;
			else
				return null;
			
		}
	
	public static void updateBalances(AccountDetails account) throws SQLException, ClassNotFoundException 
	 {
				
				JdbcMain jdbc=new JdbcMainImp();
			    jdbc.updateBalance(account);
	 }
	
	public static void updateOnlineTransactions(int accountNumber,AccountDetails userAccount,AccountDetails transferAccount,String type,int amount) throws SQLException
	{
		
		JdbcMain jdbc=new JdbcMainImp();
		jdbc.updateOnlineTransaction(accountNumber, userAccount, transferAccount, type, amount);
	}
	public static void updateWithdrawTransactions(int accountNumber,AccountDetails userAccount,String type,int amount) throws SQLException, ClassNotFoundException 
	{
		JdbcMain jdbc=new JdbcMainImp();
		jdbc.updateWithdrawTransaction(accountNumber, userAccount, type, amount);
	}
	
	
	public static Transaction[] statements(int userAccount) throws SQLException 
	{
		
		JdbcMain jdbc=new JdbcMainImp();
		return jdbc.statement(userAccount);
		
	}
	
	public static void onlineTransferAccounting(AccountDetails userAccount,AccountDetails transferAccount,int amount) throws Exception 
	{			
			
		 JdbcMain jdbc=new JdbcMainImp();
		 jdbc.updateBalance(userAccount);
		 jdbc.updateBalance(transferAccount);
		 jdbc.updateOnlineTransaction(userAccount.accountNumber, userAccount, transferAccount, "Debit", amount);
		 jdbc.updateOnlineTransaction(transferAccount.accountNumber, userAccount, transferAccount, "Credit", amount);
		 System.out.println("onlineTransferAccounting suc");
							
	}
	
	public static void withdrawAccounting(AccountDetails userAccount,int amount) throws Exception 
	{
		 JdbcMain jdbc=new JdbcMainImp();
		 jdbc.updateBalance(userAccount);
		 jdbc.updateWithdrawTransaction(userAccount.accountNumber, userAccount,"Debit", amount);
					
	}


	
	
	
	
	
	
	
	
	

}
