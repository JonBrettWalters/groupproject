<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h1>Welcome, <c:out value="${user.firstName}"/></h1>
		
		<h3>Books from everyone shelves:</h3>
		<a href="/logout">logout</a>
		<a href="/dashboard">Dashboard</a>
		
		<div class="container">
			<h3><span style="color: red;"><c:out value="${post.user.title"/></span> 
			<span style="color: rebeccapurple;"><c:out value="${post.subtitle}"/></span> by 
			<span style="color: darkgreen;"><c:out value="${post.plannedDate}"/></span></h3>
		</div>
		
		<div class="container">
			
			<p><c:out value="${post.description}"/></p>
			<hr />
		
		</div>
		
	</div>

</body>
</html>