<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items Page</title>
</head>
<body>
<%@ page import = "java.util.List" %>
<%@ page import = "com.cmr.prj.util.ItemsRecord" %>

<%


List<ItemsRecord> Itemslist = (List<ItemsRecord>)request.getAttribute("ItemsList");

%>

<div align="center">

<center>
<table border="2" cellspacing="0" cellpadding="3">

<tr>
<td> Item Id </td>
<td> Item Name </td>
<td> Items Left </td>


</tr>


<%

    for(ItemsRecord stud:Itemslist)
    {

%>


<tr>
<td> <%= stud.getItemid() %> </td>
<td> <%= stud.getItemname() %> </td>
<td> <%= stud.getItemsleft() %> </td>


<%
String queryString = "itemid="+ stud.getItemid() + "&itemname=" + stud.getItemname() + "&itemsleft=" + stud.getItemsleft() +  "";
%>
<td> <a href="updateitems.jsp?<%=queryString%>" ><button type="button"> Update Record </button></a> </td>
<td> <a href="deleteitems?itemid=<%=stud.getItemid() %>"><button type="button"> Delete Record</button> </a>

</tr>






<%

    }
%>





</table>
</center> <br>
<a href="items.html"> <button type="button">Go Back</button> </a> &nbsp;
<a href="success.jsp"><button type="button">Home</button></a>

</div>
</body>
</html>