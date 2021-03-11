package com.atm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface JdbcMain 
{
	static String url="jdbc:mysql://localhost:3306/zohobank";
	static String userName="root";
	static String password="";
	
	//this method is to check the authentication of the user
	public  abstract AccountDetails logInVerification(int accountNumber,int pinNumber) throws SQLException;
	
	//this method is to check whether the input account number is right or wrong
	public abstract AccountDetails accountVerification(int accountNumber) throws SQLException,ClassNotFoundException;
	
	//this method is to update user account balance in database
	void updateBalance(AccountDetails account) throws SQLException,ClassNotFoundException;
	
	//this method is to update transaction details in database for the online transaction
	void updateOnlineTransaction(int accountNumber,AccountDetails userAccount,AccountDetails transferAccount,String type,int amount) throws SQLException;
	
	//this method is to update transaction details in database for the withdrawal
	void updateWithdrawTransaction(int accountNumber,AccountDetails userAccount,String type,int amount) throws SQLException, ClassNotFoundException ;

	//this method is to give you last five transaction of given user
	  List<Transaction> statement(int userAccount) throws SQLException;
	  
	  List<AccountDetails> accountDetails() throws SQLException;

}
