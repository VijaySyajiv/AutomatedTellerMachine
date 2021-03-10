<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
	      <style>
	      body { 
			    background-color: #000080;
				}
				h1{
				background-color: white;
               text-align: center;
              }
              p{
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
	        <form action="login" method="post">
	           		Enter the Account Number:<input type="text" name="accountNumber"><br>
	           		<br>
	           	 	Enter the Pin Number:<input type="password" name="pinNumber"><br>
	           	 	<input type="submit">
	           </form>
	                 <p style="color:red">Incorrect login Details</p>
	           </div>

</body>
</html>