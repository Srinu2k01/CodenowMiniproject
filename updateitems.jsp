<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items Updating Page</title>
</head>
<body>
<center>
<form action="updateitems">


<table>

<tr>
<td> Item Id </td>
<td> <input type="text" name="itemid" value=<%=request.getParameter("itemid") %> readonly="readonly">
</td>
</tr>


<tr>
<td> Supplier Name </td>
<td> <input type="text" name="itemname" value=<%=request.getParameter("itemname") %>>
</td>
</tr>

<tr>
<td> Items Left </td>
<td> <input type="text" name="itemsleft" value=<%=request.getParameter("itemsleft") %>>
</td>
</tr>



<tr>
<td colspan=2>  <input type="submit"  value="Update Items" %>
</td>
</tr>


</table><br>
<a href="retrieveitems"> <button type="button">Go Back</button> </a> &nbsp;


</form>
</center>
</body>
</html>