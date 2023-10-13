<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/styles.css">
<title>Burger Tracker II</title>
</head>
<body>
	<div id="page-container">
		
		<div id="table-container">
			<h1>Burger Tracker</h1>
			<table class="table table-secondary table-striped table-hover">
				<thead>
					<tr>
						<th>Burger Name</th>
						<th>Restaurant Name</th>
						<th>Rating (out of 5)</th>
						<th>User Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--  We'll be looping here! -->
					<c:forEach var="burger" items="${burgers}">
						<tr>
							<td><c:out value="${burger.burgerName}" /></td>
							<td><c:out value="${burger.restaurant}" /></td>
							<td><c:out value="${burger.rating}" /></td>
							<td><a href="/burger/edit/${burger.id}">Edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div id="form-container">
			<h2>Add a Burger:</h2>
			<form:form action="/burger" method="post" modelAttribute="burger">
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
					<input type="submit" value="Add Burger" class="btn btn-primary"/>
				</div>
			</form:form>
		</div>
	</div>
	
</body>
</html>