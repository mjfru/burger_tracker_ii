<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/editStyle.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Edit Burger</title>
</head>
<body>
	<div id="form-container">
		<div id="header">
			<h2>Edit a Burger:</h2>
			<a href="/">Back to Home</a>
		</div>

		<form:form action="/burger/${burger.id}" method="post" modelAttribute="burger">
			<input type="hidden" name="_method" value="put"/>
			<div>
				<form:label path="burgerName">Burger Name:</form:label><br>
				<form:errors path="burgerName" class="error-message"/>
				<form:input type="text" path="burgerName" class="string-input"/>
			</div>
			<div>
				<form:label path="restaurant">Restaurant Name:</form:label><br>
				<form:errors path="restaurant" class="error-message"/>
				<form:input type="text" path="restaurant" class="string-input"/>
			</div>
				<form:label path="rating">Rating:</form:label><br>
				<form:errors path="rating" class="error-message"/>
				<form:input type="number" path="rating" class="number-input" min="1" max="5"/>
			<div>
				<form:label path="notes">Notes:</form:label><br>
				<form:errors path="notes" class="error-message"/>
				<form:textarea path="notes" class="string-input"></form:textarea>
			</div>
			<div id="submit-button">
				<input type="submit" value="Update Burger" class="btn btn-primary"/>
			</div>
		</form:form>
	</div>
</body>
</html>