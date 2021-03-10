<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
		<h1 >Zoho Bank online Money Transfer</h1><br>
		 <h1 > Minimum Rs 1000 To Maximum Rs 10,000</h1><br>
			      <div><br>
			        <form action="amountValidate" method="post">
			           		Enter the Amount:<input type="text" name="amount"><br>
			           		<br>
			           	 	<input type="submit">
			           </form><br>
			            <p style="color:red">Please Give Valid Input</p>
			      </div>

</body>
</html>