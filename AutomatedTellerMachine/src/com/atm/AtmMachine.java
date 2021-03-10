package com.atm;

public class AtmMachine {
		static int  atmBalance;
	    int thousandRupees,fiveHundredRupees,hundredRupees;
	    //constructor
	    AtmMachine(int atmBalance){
	    	this.atmBalance=atmBalance;
	    	int temp=atmBalance/100000; 
	    	thousandRupees=temp*20;
	    	fiveHundredRupees=temp*100;
	    	hundredRupees=temp*300;
	    }
   

}
