<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="/css/main.css"> <script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/main.css">
<title>Blog Life</title>
</head>
<body>




<form:form action="/register" method="post" modelAttribute="User">

	<table>
		<thead>
	    	<tr>
	            <td colspan="2">Register</td>
	        </tr>
	    </thead>
	    <thead>
	    	<tr>
	            <td class="float-left">First Name:</td>
	            <td class="float-left">
	            	<form:errors path="firstName" class="text-danger"/>
					<form:input class="input" path="firstName"/>
	            </td>
	        </tr>
			<tr>
	            <td class="float-left">Last Name:</td>
	            <td class="float-left">
	            	<form:errors path="lastName" class="text-danger"/>
					<form:input class="input" path="lastName"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">Email:</td>
	            <td class="float-left">
	            	<form:errors path="email" class="text-danger"/>
					<form:input class="input" path="email"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">Password:</td>
	            <td class="float-left">
	            	<form:errors path="password" class="text-danger"/>
					<form:input class="input" path="password" type="password"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">Confirm Password:</td>
	            <td class="float-left">
	            	<form:errors path="confirm" class="text-danger"/>
					<form:input class="input" path="confirm" type="password"/>
	            </td>
	        </tr>
	        <tr>
	        	<td colspan=2><input class="input" class="button" type="submit" value="Submit"/></td>
	        </tr>
	    </thead>
	</table>
</form:form>
<hr>
<form:form action="/login" method="post" modelAttribute="LoginUser">

	<table>
		<thead>
	    	<tr>
	            <td colspan="2">Log In</td>
	        </tr>
	    </thead>
	    <thead>
	        <tr>
	            <td class="float-left">Email:</td>
	            <td class="float-left">
	            	<form:errors path="email" class="text-danger"/>
					<form:input class="input" path="email"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">Password:</td>
	            <td class="float-left">
	            	<form:errors path="password" class="text-danger"/>
					<form:input class="input" path="password" type="password"/>
	            </td>
	        </tr>
	        <tr>
	        	<td colspan=2><input class="input" class="button" type="submit" value="Submit"/></td>
	        </tr>
	    </thead>
	</table>
</form:form>
</html>