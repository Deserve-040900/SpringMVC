<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="UTF-8">
		<title>HomePage</title>
		<link rel="stylesheet" href="<c:url value="/css/style.css" />" />
	</head>
	<body>
		<h1>
			<spring:message code="page.title" />
		</h1>
		<h3>
			<spring:message code="page.welcome" />
		</h3>
		<img alt="tiger-cute" src="<c:url value="/img/Tiger.jpg" />">
	</body>
</html>