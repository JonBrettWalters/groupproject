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
	<title>New Post</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

	<h1>Add a post</h1>

	<a href="/dashboard">Dashboard</a>

	<div class="container">
		<form:form action="/posts" modelAttribute="posts" class="form" method="post"> <!-- form needs to be updated -->
		
			<div class="form-row">
				<form:errors path="title" class="error"/>
				<form:label for="title" path="title">Title:</form:label>
				<form:input type="text" path="title" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:errors path="subtitle" class="error"/>
				<form:label for="subtitle" path="subtitle">Subtitle:</form:label>
				<form:input type="text" path="subtitle" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:errors path="plannedDate" class="error"/>
				<form:label for="plannedDate" path="plannedDate">Date:</form:label>
				<form:input type="date" min="2018-01-01" max="2199-12-31" path="plannedDate" class="form-control"/>
			</div>
			<div class="form-row">
				<form:errors path="description" class="error"/>
				<form:label for="description" path="description">Description:</form:label>
				<form:textarea path="description" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:errors path="user" class="error"/>
				<form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
			</div>
			
			<div class="form-row">
				<input type="submit" value="Submit" class="btn-primary"/>
			</div>
			
		</form:form>
	</div>



</div>

</body>
</html>