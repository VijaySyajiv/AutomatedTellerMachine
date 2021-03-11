<%@ page import="com.atm.*" language="java" contentType="text/html; charset=ISO-8859-1"
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
	         try{
	         out.print(request.getAttribute("balance"));
	         }
	       catch(Exception e){
	    	   response.sendRedirect("Home.jsp");
	       }
	       %>
	        <form action="Home.html" method="post">
	           		<p style="color:red">Press Proceed  button to Process</p>
	           	 	<input type="submit" value="Proceed">
	           </form>
	       
	           </div>

</body>
</html>