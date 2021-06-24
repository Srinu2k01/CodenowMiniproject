<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Update Page</title>
</head>
<body>
		<form action="updatepassword">

<center>
<table border="2"  cellspacing="0" cellpadding="3">

<tr>
<td colspan="2"> Update Password </td>
</tr>

<tr>
<td> User Name:  </td>
<td> <input type="text" name="uname" value=<%=request.getParameter("userName") %> readonly="readonly"/> </td>
</tr>

<tr>
<td> Enter Old Password:  </td>
<td> <input type="text" name="oldpasswd" placeholder="Password"/> </td>
</tr>

<tr>
<td> Enter New Password:  </td>
<td> <input type="text" name="newpasswd" placeholder="Password"/> </td>
</tr>

<tr>
<td> Confirm New Password:  </td>
<td> <input type="text" name="confirmpasswd" placeholder="Re Enter Password"/> </td>
</tr>


<tr>
<td> <input type="submit" value="update password"/> </td>
<td> <input type="reset" value = "clear"/> </td>
</tr>

</table> <br>

 <a href="success.jsp" style="color: crimson;"><button type="button">Home</button></a>

</center>

</form>
</body>
</html>