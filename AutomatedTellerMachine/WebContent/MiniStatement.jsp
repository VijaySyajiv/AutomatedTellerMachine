<%@ page import="com.atm.Transaction" import="com.atm.AccountDetails" import="java.util.Collection" import="java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>withdraw Page</title>
		 <style>
	      body { 
			    background-color: #000080;
				}
				h1{
				background-color: white;
               text-align: center;
              }
              p{
              colour:red; 
              text-align: center;
              }
              div{
                text-align:center;
				background-color:#00868B;
			}
	      </style>
</head>
<body>
      <h1 >Zoho Bank Welcomes You</h1>
	      <div>
	       <p style="color:red">Account Balance </p>
	      
	       <%
	      		    AccountDetails account=(AccountDetails)session.getAttribute("account");
	               int AccountNumber=account.getAccountNumber(),Balance=account.getAccountBalance();
	               String AccountName=account.getAccountHolder();
	       
	       %>
	       <h5>AccountNumber :- <%=AccountNumber %><br>
	       AccountName :- <%=AccountName %><br>
	       Account Balance :- <%=Balance %></h5><br>
	       
	       <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>Transaction ID</b></th> 
          <th><b>Transaction Remark</b></th> 
          <th><b>Transaction Type</b></th>
          <th><b>Balance</b></th> 
         </tr> 
       
        <%List<Transaction> transaction=(List)request.getAttribute("transaction"); 
          int temp=1;
         
          
          for(int i=transaction.size()-1;i>=0;i--){%> 
        
            <tr> 
	                <td><%=temp++%></td>
	                <%
	                String remarks="";
	                   if(transaction.get(i).getAccountNumberTo()!=0)
	                   {
		                     if(transaction.get(i).getTransactionType().equals("Debit"))
		                    	 remarks="Fund Transfer to Acc "+transaction.get(i).getAccountNumberTo();
		                     else
		                    	 remarks="Fund Transfer from Acc "+transaction.get(i).getAccountNumberFrom();
	                   }
	                   else
	                	   remarks="Debited "+transaction.get(i).getTransactionAmount()+" from ATM";
	                %> 
	                <td><%=remarks%></td> 
	                <td><%=transaction.get(i).getTransactionType()%></td>
	                <td><%=transaction.get(i).getTransactionAmount()%></td> 
            </tr> 
            <%}
		          session.removeAttribute("account");
		          session.removeAttribute("menuoption");
            %> 
        </table>  
	        <form action="Home.html" method="post">
	           		<p style="color:red">Press Proceed  button to Process</p>
	           	 	<input type="submit" value="Proceed">
	           </form>
	           </div>

</body>
</html>