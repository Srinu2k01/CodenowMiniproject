<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory List Page</title>
</head>
<body>

<%@ page import = "java.util.List" %>
<%@ page import = "com.cmr.prj.util.InventoryRecord" %>

<%


List<InventoryRecord> Inventorylist = (List<InventoryRecord>)request.getAttribute("InventoryList");

%>

<div align="center">

<center>
<table border="2" cellspacing="0" cellpadding="3">

<tr>
<td> Inventory Id </td>
<td> Supplier Id </td>
<td> Item Id </td>
<td> Items Supplied</td>
</tr>


<%

    for(InventoryRecord stud:Inventorylist)
    {

%>


<tr>
<td> <%= stud.getId() %> </td>
<td> <%= stud.getSupplierid() %> </td>
<td> <%= stud.getItemid() %> </td>
<td> <%= stud.getItemssupplied() %> </td>

<%
String queryString = "Id="+ stud.getId() + "&supplierid=" + stud.getSupplierid() + "&itemid=" + stud.getItemid() + "&itemssupplied="
		+ stud.getItemssupplied() + "";
%>
<td> <a href="updateinventory.jsp?<%=queryString%>" ><button type="button"> Update Record</button> </a> </td>
<td> <a href="deleteinventory?id=<%=stud.getId() %>"> <button type="button">Delete Record</button></a>
</tr>






<%

    }
%>





</table><br>
<a href="inventory.html"> <button type="button">Go Back</button> </a> &nbsp;
<a href="success.jsp"><button type="button">Home</button></a>
</center> <br>



</div>

</body>
</html>