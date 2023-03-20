<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form:form method="post" action="/DynamicWeb/login" modelAttribute="user">
		<h1>LOGIN</h1>
		<h3>${msg}</h3>
		Username: <form:input path="username"/>
		Password: <form:password path="password"/>
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>