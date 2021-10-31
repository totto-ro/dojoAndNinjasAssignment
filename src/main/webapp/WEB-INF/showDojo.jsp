<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dojo Info</title>
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
	</head>
	<body>
		<main>
			<nav>
				<a href="/">Dashboard</a>
			</nav>
			<h2>${ dojoInfo.name } Dojo Ninjas</h2>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>Age</th>	
					</tr>
				</thead>
				<tbody>
				<c:forEach var="element" items="${ dojoInfo.ninjas }">
					<tr>
						<td>${ element.first_name } ${ element.last_name } </td>
						<td> ${ element.age } </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</main>
	</body>
</html>