<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supplier List Page</title>
</head>
<body>
<%@ page import = "java.util.List" %>
<%@ page import = "com.cmr.prj.util.SupplierRecord" %>

<%


List<SupplierRecord> SupplierList = (List<SupplierRecord>)request.getAttribute("SupplierList");

%>

<div align="center">

<center>
<table border="2" cellspacing="0" cellpadding="3">

<tr>

<td> Supplier Id </td>
<td> Supplier Name </td>
</tr>


<%

    for(SupplierRecord stud:SupplierList)
    {

%>


<tr>
<td> <%= stud.getSupplierid() %> </td>
<td> <%= stud.getSuppliername() %> </td>
<%
String queryString = "supplierid="+ stud.getSupplierid() + "&suppliername=" + stud.getSuppliername()  + "";
%>
<td> <a href="updatesupplier.jsp?<%=queryString%>" > <button type="button">Update Record</button> </a> </td>
<td> <a href="deletesupplier?supplierid=<%=stud.getSupplierid() %>"> <button type="button">Delete Record</button> </a>



</tr>






<%

    }
%>





</table>
</center> <br>
<a href="supplier.html"> <button type="button">Go Back</button> </a> &nbsp;
<a href="success.jsp"><button type="button">Home</button></a>

</div>

</body>
</html>