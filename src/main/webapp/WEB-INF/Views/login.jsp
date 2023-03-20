<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form:form method="POST" action="/DynamicWeb/login" modelAttribute="user">
		<h1>LOGIN</h1>
		<c:if test="${msg.equals('SUCCESSFUL') == true}">
			<h3 style="color:darkblue;">${msg}</h3>
		</c:if>
		<c:if test="${msg.equals('FAILED!!') == true}">
			<h3 style="color:red;">${msg}</h3>
		</c:if>
		Username: <form:input path="username"/>
		Password: <form:password path="password"/>
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>