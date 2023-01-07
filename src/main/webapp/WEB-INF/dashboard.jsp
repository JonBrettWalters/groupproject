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
	<title>Dashboard</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h1> <c:out value="${user.firstName}"/> blog</h1>
		
		
		<a href="/logout">Logout</a>
		<a href="/blogs/add">+ Add to blog</a>
		
		<table class="table">
		
			<tr>
				<th>Blog Title</th>
				<th>Subtitle</th>
				<th>Date</th>
				<th>remove/edit</th>
			</tr>
			<c:forEach var="post" items="${foundUser.posts}">
			
				<tr>
					<td><a href="/blogs/${post.id}/view"><c:out value="${post.title}"/></a></td>
					<td><c:out value="${post.subtitle}"/></td>
					<td><c:out value="${post.plannedDate}"/></td>
					<td> <a href="/blogs/${post.id}/edit"> Edit </a> | <a href="/blogs/${post.id}/delete"> Delete</a>  </td> <!-- delete and edit need to be updated -->
				</tr>
			</c:forEach>
		
		</table>
	</div>

</body>
</html>