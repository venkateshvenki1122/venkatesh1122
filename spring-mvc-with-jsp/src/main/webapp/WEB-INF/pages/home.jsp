<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venki Web Page</title>
<style type="text/css">
table{

border:5px solid orange;
background-color:red;
}

tr,td,th{
color:red;
background-color:orange;
border:2px solid blue;


}

</style>
</head>
<body>
${list}

<table>

<tr> 
<th>Product Id </th>
<th>Product Name </th>
<th>Rate Per Unit </th>
</tr>
<c:forEach items="${list}" var="eachItem">
<tr>
<td>${eachItem.productId}</td>
<td>${eachItem.productName} </td>
<td>${eachItem.price}</td>

</tr>
</c:forEach>
</table>
</body>
</html>