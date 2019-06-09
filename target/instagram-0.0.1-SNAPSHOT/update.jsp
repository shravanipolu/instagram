<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateCustomer">
Name:<input type="text" name="name" value="${editCustomList.name}"><br><br>
Mail:<input type="text" name="mail" value="${editCustomList.mail}"><br><br>
Password:<input type="password" name="pwd" value="${editCustomList.pwd}" ><br><br>
Mobile:<input type="text" name="mob" value="${editCustomList.mob}"><br><br>
<input type="submit" value="Update"><br><br>
</form>

</body>
</html>