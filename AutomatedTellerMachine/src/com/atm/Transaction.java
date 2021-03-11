package com.atm;

public class Transaction {
	
	String transactionType;
	int accountNumber,accountNumberFrom,accountNumberTo,transactionAmount;
	
	public Transaction( int accountNumber, int accountNumberFrom, int accountNumberTo,String transactionType,int transactionAmount) {
		
		this.transactionType = transactionType;
		this.accountNumber = accountNumber;
		this.accountNumberFrom = accountNumberFrom;
		this.accountNumberTo = accountNumberTo;
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public int getAccountNumberFrom() {
		return accountNumberFrom;
	}

	public int getAccountNumberTo() {
		return accountNumberTo;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionType=" + transactionType + ", accountNumber=" + accountNumber
				+ ", accountNumberFrom=" + accountNumberFrom + ", accountNumberTo=" + accountNumberTo
				+ ", transactionAmount=" + transactionAmount + "]";
	}
	
	
	

}
