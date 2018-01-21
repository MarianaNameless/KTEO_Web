<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- this jsp page presents all of our services and is incuded in all other pages-->
<title>Services</title>
</head>
<body>
<b> Υπηρεσίες </b><br>
<a href=' <c:url value="/rules"></c:url>' > Κανόνες λειτουργίας </a><br>
<a href=" <c:url value="/points"></c:url>" > Σημεία εξυπηρέτησης </a><br>
<a href=" <c:url value="/instructions"></c:url>" > Οδηγίες συντήρησης </a><br>
<a href=" <c:url value="/check"></c:url>" > Έλεγχος οχήματος </a><br>
<a href=" <c:url value="/users/register"></c:url>" > Εγγραφή </a><br>
<a href=" <c:url value="/users/login"></c:url>" > Είσοδος </a>
</body>
</html>