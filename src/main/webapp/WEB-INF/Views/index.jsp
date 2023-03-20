<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="UTF-8">
		<title>HomePage</title>
	</head>
	<body>
		<h1>Hello ${name}</h1>
		${Category}
		<ul>
			<c:forEach items="${Category}" var="cat">
				<li>${cat}</li>
			</c:forEach>
		</ul>
		<!-- multiplication table with forEach Loop -->
		<ul>
			<c:forEach begin="1" end="10" var="i">
				<li>2 * ${i} = ${2*i}</li>
			</c:forEach>
		</ul>
	</body>
</html>