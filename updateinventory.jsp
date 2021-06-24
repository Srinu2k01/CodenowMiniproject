<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Inventory Page</title>
</head>
<body>
<form action="updateinventory">

<center>
<table>

<tr>
<td> Id </td>
<td> <input type="text" name="id" value=<%=request.getParameter("Id") %> readonly="readonly">
</td>
</tr>


<tr>
<td> Supplier Id </td>
<td> <input type="text" name="supplierid" value=<%=request.getParameter("supplierid") %>>
</td>
</tr>

<tr>
<td> Item Id </td>
<td> <input type="text" name="itemid" value=<%=request.getParameter("itemid") %>>
</td>
</tr>

<tr>
<td> Items Left </td>
<td> <input type="text" name="itemssupplied" value=<%=request.getParameter("itemssupplied") %>>
</td>
</tr>


<tr>
<td colspan=2>  <input type="submit"  value="Update Inventory" %>
</td>
</tr>






</table><br>
<a href="retrieveinventory"> <button type="button">Go Back</button> </a> &nbsp;




</form>

</center>
</body>
</html>