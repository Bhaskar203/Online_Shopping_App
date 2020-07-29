<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <style>  
    table,tr,td
    {
border:1px solid black;
width:30%;
text-align:center;
background-color:white;

}

</style>
</head>

<body bgcolor="Olive">

<table  border="1px" >

<thead>
<tr>
<th>Cart No</th>
<th>Product Id</th>
<th>Customer Id</th>
<th>Quantity</th>

</tr>
</thead>
<tbody>
<c:forEach  var="s" items="${list}">
<tr>
<td><h4><c:out value="${s.getCartno()}"></c:out></h4></td>

<td><h4><c:out value="${s.getId()}"></c:out></h4></td>

<td><h4><c:out value="${s.getCid()}"></c:out></h4></td>


<td><h4><c:out value="${s.getQty()}"></c:out></h4></td>

</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>  