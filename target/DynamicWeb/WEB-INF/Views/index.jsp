<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HomePage</title>
		<link rel="stylesheet" href="<spring:url value="/css/style.css" htmlEscape="true"/>" />
	</head>
	<body>
		<h1>
			<spring:message code="page.title" />
		</h1>
		<h3>
			<spring:message code="page.welcome" />
		</h3>
		<img alt="tiger-cute" src="<spring:url value="/img/Tiger.jpg"/>" >
		<a href="<spring:url value="/login" htmlEscape="true"/>" >Go to Login page!</a>
		
		<form method="post" enctype="multipart/form-data" action="">
			<input type="file" />
			<input type="submit" value="Upload" />
		</form>
	</body>
</html>