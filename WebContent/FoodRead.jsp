<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="foodread" method="post">
		<h1>Search for a Food Item by ItemId</h1>
		<p>
			<label for="item">itemId</label> <input id="item" name="item"
				value="">
		</p>
		<p>
			<input type="submit"> <br /> <br /> <br /> <span
				id="successMessage"><b>${messages.success}</b></span> <span
				id="test"><b>${messages.test}</b></span>
		</p>
	</form>

	<h1>Results :</h1>
	<table border="1">
		<tr>
			<th>Item</th>
			<th>Value</th>
			
		</tr>

		<c:forEach items="${i}" var="it">
			<tr>

				<td><c:out value="${it.getItem()}" /></td>
				<td><c:out value="${it.getValue()}" /></td>

			</tr>
		</c:forEach>
		
		<p>
		
		<c:out value="${test}"/>
		</p>
</body>
</html>