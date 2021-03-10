package com.atm;

public class AccountDetails {
	int accountNumber;
	String accountHolder;
	int pinNumber;
	int accountBalance;
	
	//constructor to initialize the value in the field
	public AccountDetails(int accountNumber, String accountHolder, int pinNumber, int accountBalance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.pinNumber = pinNumber;
		this.accountBalance = accountBalance;
	}
	
	public AccountDetails(int accountNumber, String accountHolder, int accountBalance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.accountBalance = accountBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public int getAccountBalance() {
		return accountBalance;
	} 
	
	
}
