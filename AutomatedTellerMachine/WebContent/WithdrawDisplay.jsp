<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	      <title>withdraw Page</title>
	      <style>
	      body { 
			    background-color: #000080;
				}
				h1{
				background-color: white;
               text-align: center;
              }
              h2{
              text-align: center;
              }
              div{
                text-align:center;
				background-color:#00868B;
			}
	      </style>
	</head>
	<body>
	      <h1 >Amount Should be multiple of 100 and Min Rs 100 Max Rs 10,000</h1>
	      <div>
	        <form action="amountValidate" method="post">
	           		<h2>Enter the Amount:</h2><input type="text" name="amount"><br>
	           		<br>
	           		<input type="submit"><br>
	           		 <p style="color:red">Please Give Valid Input</p>
	           </form>
	      </div>
	           
	           
	   
	</body>
</html>
</html>