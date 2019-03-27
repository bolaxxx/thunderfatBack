<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags"
prefix="spring"%>
<spring:url value="/resources" var="urlPublic" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<link rel = "stylesheet" href= "${urlPublic}/bootstrap/css/bootstrap.css">

<script src="${urlPublic}/bootstrap/js/bootstrap.js"></script>
<title>la pagina home</title>
</head>
<body>
${urlPublic}
<h1>esto es home</h1>
<jsp:include page="../views/includes/menu.jsp"></jsp:include>
</body>
</html>