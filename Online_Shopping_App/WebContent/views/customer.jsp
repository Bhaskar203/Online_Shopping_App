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
<h1>Adding Customer</h1><br>

<form action="addcustomer"> 
Enter Customer id:<input type="text" name="cid"><br><br>
Enter Customer name:<input type="text" name="name"><br><br>
Enter Customer Password:<input type="text" name="pass"><br><br>
Enter Phone no:<input type="text" name="phoneno"><br><br>
Enter Amount into Wallet:<input type="text" name="wallet"><br><br>
Enter Location:<input type="text" name="location"><br><br>
Enter Pincode:<input type="text" name="pincode"><br><br>
<input type="submit" value="Add_Customer"><br><br>
</form>

</body>
</html>