<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
//break point 
function editDetails(mail){
	
	alert('edit button triggered'+mail);
	document.forms[0].action="${pageContext.request.contextPath}/editView?mailToEdit="+mail;
	document.forms[0].method="post";
	document.forms[0].submit();	


}

function deleteDetails(mail){
	alert('edit button triggered'+mail);
	
	document.forms[0].action="${pageContext.request.contextPath}/deleteView?mailIdToDelete="+mail;
	document.forms[0].method="post";
	document.forms[0].submit();	

}

</script>


</head>
<body>
login successful!!!
<form>
<table>
<tr>
<th>name</th>
<th>mail</th>
<th>password</th>
<th>mobile</th>
</tr>
<c:forEach items="${SetList}" var="userObject">
			<tr>
				<td>${userObject.name}</td>

				<td>${userObject.mail}</td>

				<td>${userObject.pwd}</td>

				<td>${userObject.mob}</td>
				<td><input type="button"
					onclick="editDetails('${userObject.mail}')" value="Edit"></td>
				<td><input type="button"
					onclick="deleteDetails('${userObject.mail}')" value="Delete"></td>
			</tr>
		</c:forEach>




</table>
</form>
</body>
</html>