<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<div style="float: right;"> <a href="login.html"> <button type="button">Logout</button> </a> </div>
<h1>   Congratulations..........Welcome to Login Page </h1>
<h2>  Hi....  </h2>
<a href="updatepassword.jsp?userName=<%=request.getAttribute("userName") %>"> <button type="button">Click Here to Update the Password</button> </a> <br><br>

<div style="margin-left: 500px;">
    <a href="inventory.html" style="color: crimson;"><button type="button">Inventory Table Operations</button></a><br><br>
     <a href="supplier.html" style="color:  brown;"><button type="button">Supplier Table Operations</button></a><br><br>
      <a href="items.html" style="color: rgb(31, 250, 11);"><button type="button">Items Table Operations</button></a>
</div>
</body>
</html>