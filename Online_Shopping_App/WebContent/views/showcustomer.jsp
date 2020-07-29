<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <style>  
    
    table,tr,td
    {

width:30%;
text-align:center;
background-color:white;
padding: 4px 50px;


}

</style>
</head>


<body bgcolor="orange">
<h1>List of Customers</h1>

<table border="2px" >

<thead>
<tr>
<th>Customer Id</th>
<th>Customer Name</th>
<th>Customer Ph.No</th>
<th>Location</th>
<th>Pincode</th>

</tr>
</thead>

<tbody>
<c:forEach  var="s" items="${list}">
<tr>
<td><h4><c:out value="${s.getCid()}"></c:out></h4></td>
<td><h4><c:out value="${s.getName()}"></c:out></h4></td>
<td><h4><c:out value="${s.getPhoneno()}"></c:out></h4></td>
<td><h4><c:out value="${s.getLocation()}"></c:out></h4></td>
<td><h4><c:out value="${s. getPincode()}"></c:out></h4></td>
</tr>
</c:forEach>
</tbody>
</table>


</body>
</html>  