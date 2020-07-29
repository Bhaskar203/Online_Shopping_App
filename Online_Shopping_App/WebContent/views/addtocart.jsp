<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

body {
	text-align: center;
}
</style>
</head>

<body bgcolor="orange">
<h1>Adding To Cart</h1>
<form action="addcart">

Enter the  Customer-Id:<input type="text" name="cid"><br><br>
Enter the  Product-Id:<input type="text" name="id"><br><br>
Enter the  No.Of Products you want to buy:<input type="text" name="qty"><br><br>
<input type="submit" value="Add To Cart">
</form>

</body>

</html>