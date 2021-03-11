package com.atm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AtmMachine extends HttpServlet {
	
	
		static int  atmBalance;
	    static int thousandRupees,fiveHundredRupees,hundredRupees;
	    static int hn,fn,tn;
	    //constructor
	    AtmMachine(int atmBalance){
	    	this.atmBalance=atmBalance;
	    	int temp=atmBalance/100000; 
	    	thousandRupees=temp*20;
	    	fiveHundredRupees=temp*100;
	    	hundredRupees=temp*300;
	    	System.out.println(AtmMachine.atmBalance);
	    }
	    
	    
	    public static boolean denomininations(int amount) 
	    {
	    	int hn=0,fn=0,tn=0,tempAmount=amount;
	    	//amount<=5000
	    	if(amount<=5000) 
	    	{
				    	if(amount<=1000 && AtmMachine.hundredRupees>=10)
				    	{
				    		hn=amount/100;
				    		AtmMachine.hundredRupees-=hn;
				    		amount-=hn*100;
				    		//return true;
				    	}
				    	//else
				    		//return false; because  hundred not there is not
				    	if(amount>1000 && AtmMachine.thousandRupees>=1)
				    	{
				    	    amount-=1000;
				    	    AtmMachine.thousandRupees-=1;
				    	    tn=1;
				    	}
				    	if(amount>0 && AtmMachine.hundredRupees>=10 && amount%500==0)
				    	{			    	 
				    		int temp=10;
				    		while(temp>0 &&amount>=100 )
				    		{
			                    amount-=100;
			                    temp--;
			                }
				    		AtmMachine.hundredRupees-=(10-temp);
				    		hn=(10-temp);
				    	}
				    	
			    		
			    		if(amount>=500) 
			    		{
				    		AtmMachine.fiveHundredRupees-=(amount/500);
				    		fn=(amount/500);
				    		amount-=(amount/500)*500;
			    		}
			    		
			    		if(amount>0 && AtmMachine.hundredRupees>=10)
				    	{			    	 
				    		int temp=10;
				    		while(temp>0 &&amount>=100 )
				    		{
			                    amount-=100;
			                    temp--;
			                }
				    		AtmMachine.hundredRupees-=(10-temp);
				    		hn=(10-temp);
				    	}
			    	
	        }
	    	else
	    	{	    			
	    		if(amount>1000 && AtmMachine.thousandRupees>=3)
		    	{
	    			int temp=3;
		    		while(temp>0 &&amount>=1000 )
		    		{
	                    amount-=1000;
	                    temp--;
	                }
		    	    AtmMachine.thousandRupees-=(3-temp);
		    	    tn=(3-temp);
		    	}
	    		if(amount>0 && AtmMachine.hundredRupees>=10 && amount%500==0)
		    	{			    	 
		    		int temp=10;
		    		while(temp>0 &&amount>=100 )
		    		{
	                    amount-=100;
	                    temp--;
	                }
		    		AtmMachine.hundredRupees-=(10-temp);
		    		hn=(10-temp);
		    	}
	    	 
	    		if(amount>=500 ) 
	    		{
		    		AtmMachine.fiveHundredRupees-=(amount/500);
		    		fn=(amount/500);
		    		amount-=fn*500;
	    		}
	    		
	    		if(amount>0 && AtmMachine.hundredRupees>=10)
		    	{			    	 
		    		int temp=10;
		    		while(temp>0 &&amount>=100 )
		    		{
	                    amount-=100;
	                    temp--;
	                }
		    		AtmMachine.hundredRupees-=(10-temp);
		    		hn=(10-temp);
		    	}	    	
	    	}
	    	AtmMachine.hn=hn;
	    	AtmMachine.fn=fn;
	    	AtmMachine.tn=tn;
	    	System.out.println(AtmMachine.hundredRupees+" "+hn);
			System.out.println(AtmMachine.fiveHundredRupees+" "+fn);
			System.out.println(AtmMachine.thousandRupees+" "+tn);
	    	int temp=((hn*100)+(fn*500)+(tn*1000));
	          return temp==tempAmount?true:false ;
	    }
   

}
