<%@ page import="com.atm.Transaction" import="com.atm.AccountDetails" import="java.util.List" import="com.atm.JdbcMainApi" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Accounts Holder Info Page</title>
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
	      
	       
	       
	       
	       <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>Account Number</b></th> 
          <th><b>Account Holder Name</b></th> 
          <th><b>Pin Number</b></th>
          <th><b>Balance</b></th> 
         </tr> 
       
        <%List<AccountDetails> account=JdbcMainApi.accountDetailss();; 
          for(AccountDetails a:account){%> 
        
            <tr> 
	              
	                <td><%=a.getAccountNumber()%></td> 
	                <td><%=a.getAccountHolder()%></td>
	                <td><%=a.getPinNumber()%></td> 
	                <td><%=a.getAccountBalance()%></td> 
            </tr> 
            <%}
		          session.removeAttribute("account");
		          session.removeAttribute("menuoption");
            %> 
        </table>
        <form action="Home.html" method="post">
	           		
	           	 	<input type="submit">
	           </form>
           
	       
	           </div>

</body>
</html>