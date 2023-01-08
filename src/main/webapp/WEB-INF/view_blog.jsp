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

    <link rel="stylesheet" type="text/css" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<a href="/dashboard">Dashboard</a>
		<table>
		
			<h3><span class="td"><c:out value="${viewPost.title}"/></span> 
			<span style="color: rebeccapurple;"><c:out value="${viewPost.subtitle}"/></span> by 
			<span style="color: darkgreen;"><c:out value="${viewPost.plannedDate}"/></span></h3>
		</table>
		<div class="container">
			
			<p><c:out value="${viewPost.description}"/></p>
			<hr />
		
		</div>
	
	</div>

</body>
</html>