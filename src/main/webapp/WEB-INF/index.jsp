<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dojos and Ninjas</title>
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
	</head>
	<body>
		<main>
			<h1>All Dojos</h1>
			<table>
				<thead>
					<tr>
						<th> Dojo Name </th>
						<th> Created </th>
						<th>Ninja Count</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="element" items="${dojoList}">
					<tr>
						<td><a href="/dojos/${ element.id }">${element.name}</a></td>
						<td><fmt:formatDate value="${ element.created_at }" type="date" pattern="dd/MMM/yyyy"/></td>
						<td>${fn:length( element.getNinjas() )} ninja</td>				
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="div">
				<a class="links" href="/dojos/new">New Dojo </a>
				<a class="links" href="/ninjas/new"> New Ninja</a>
			</div>
		</main>
	</body>
</html>