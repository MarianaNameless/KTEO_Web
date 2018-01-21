<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Έλεγχος</title>
</head>
<body>
<%@ include file="services.jsp" %><!-- include jsp page that presents all of our services -->
<br>
Εισάγετε την ημερομηνία του τελευταίου ελέγχου του οχήματός σας(dd-MM-yyyy): <br>
<!--  user is requested to provide a date -->
<form action="check" method="POST">
<input type="text" name="date"> <br> 
<input type="submit" value="Submit"><br>
<!-- when the check is complete, user is notified by message -->
${message}
</form>
</body>
</html>