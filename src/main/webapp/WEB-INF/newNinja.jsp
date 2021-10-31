<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New License</title>
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
	</head>
	<body>
		<main>
			<nav>
			    <a href="/">Dashboard</a>
			</nav>
			<h1>New License</h1>
			<div>
				<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
			    <p>
			    	<form:label path="dojo">Dojo</form:label>
			        <form:errors path="dojo"/>
			        <form:select path="dojo">
			        <c:forEach items="${ dojo }" var="element">
			        	<form:option value="${ element.getId() }">${ element.getName() }</form:option>
			        </c:forEach>
			        </form:select>
			    </p>
			    <p>
				    <form:label path="first_name">First Name: </form:label>
			        <form:errors path="first_name"/>
			        <form:input path="first_name"/>
			    </p>
			    <p>
				    <form:label path="last_name">Last Name: </form:label>
			        <form:errors path="last_name"/>
			        <form:input path="last_name"/>
			    </p>
			    <p>
				    <form:label path="age">Age: </form:label>
			        <form:errors path="age"/>
			        <form:input path="age"/>
			    </p>   
			    <input class="bSummit" type="submit" value="Create"/>
			</form:form>    
			</div>
		</main>
	
	</body>
</html>