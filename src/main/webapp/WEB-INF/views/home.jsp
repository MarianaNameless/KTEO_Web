<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to KTEO web site!  
</h1>
<%@ include file="services.jsp" %><!-- include jsp page that presents all of our services -->
<P> ${serverTime}. </P>
</body>
</html>
