<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Είσοδος</title>
</head>
<body>
<%@ include file="services.jsp" %>
<!-- user is requested to login with their user name and password -->
<form:form method="POST" action="login" modelAttribute="user">
	<table>
		<tr>
			<td><form:label path="UserID">User ID</form:label></td>
			<td><form:input path="UserID" type="text"/></td>
		</tr>
		<tr>
			<td><form:label path="Password">Password</form:label></td>
			<td><form:input path="Password" type="password"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"/></td>
		</tr>			
	</table>
</form:form>
${message}	
</body>
</html>