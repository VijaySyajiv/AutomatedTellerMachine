<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	      <title>Start UP Page</title>
	      <style>
	      body { 
			    background-color: #000080;
				}
				h1{
				background-color: white;
               text-align: center;
              }
              div{
                text-align:center;
				background-color:#00868B;
			}
	      </style>
	</head>
	<body>
	     <h1 >Enter  The Option</h1>
	      <form action="startup" method="post">
	         <div style="color:white;text-align:center">
	           		<input type="radio" id="MoneyLoader" name="startUpOption" value="moneyLoader">
					<label for="MoneyLoader">MoneyLoader</label>
					                                       
					<input type="radio" id="accountDetails" name="startUpOption" value="accountDetails">
					<label for="accountDetails">Account Details</label><br>
					
					<input type="radio" id="atmOperation" name="startUpOption" value="atmOperation">
					<label for="atmOperation">ATM Operation</label>                                       
					
			</div>
			<div style="text-align:center">
			    <input style="color:red" type="submit" value="startup">
			</div>
			
	      </form>
	           
	 
	</body>
</html>