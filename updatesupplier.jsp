<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supplier update Page</title>
</head>
<body>
<center>
<form action="updatesupplier">


<table>

<tr>
<td> Supplier Id </td>
<td> <input type="text" name="supplierid" value=<%=request.getParameter("supplierid") %> readonly="readonly">
</td>
</tr>


<tr>
<td> Supplier Name </td>
<td> <input type="text" name="suppliername" value=<%=request.getParameter("suppliername") %>>
</td>
</tr>




<tr>
<td colspan=2>  <input type="submit"  value="Update Supplier" %>
</td>
</tr>


</table><br>
<a href="retrievesupplier"> <button type="button">Go Back</button> </a> &nbsp;


</form>
</center>
</body>
</html>