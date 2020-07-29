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
align-content: center;
}
</style>
</head>
<body>
${message}

<table border="1px">

<thead>
<tr>
<th>Bill No</th>
<th>Product Id</th>
<th>Product Name</th>
<th>Quantity</th>
<th>Customer Id</th>
<th>Discount on one item</th>
<th>Actual bill</th>
<th>Discount on all products</th>
<th>Total Amount To be paid</th>

</tr>
</thead>

<tbody>
<c:forEach  var="s" items="${list}">
<tr>
<td><h5><c:out value="${s. getBillNo()}"></c:out></h5></td>
<td><h4><c:out value="${s.getProductId()}"></c:out></h4></td>
<td><h4><c:out value="${s.getProduct_Name()}"></c:out></h4></td>
<td><h4><c:out value="${s.getBuying_Quantity()}"></c:out></h4></td>
<td><h4><c:out value="${s.getCustomerId()}"></c:out></h4></td>
<td><h4><c:out value="${s.getDiscount()}"></c:out></h4></td>
<td><h4><c:out value="${s.getActualBill()}"></c:out></h4></td>
<td><h4><c:out value="${s.getTotal_Discount()}"></c:out></h4></td>
<td><h4><c:out value="${s.getProduct_Bill()}"></c:out></h4></td>

</tr>
</c:forEach>
</tbody>

</table>

<br><br>

<blockquote ><form action="finalbill">
<input type="submit" value="Total_Cart_Bill">
</form></blockquote>









</body>
</html>  