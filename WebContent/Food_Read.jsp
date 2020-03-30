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


	<form action="food_read" method="post">
		<h1>Search for a Food Item by ItemId</h1>
		<p>
			<label for="item">itemId</label> <input id="item" name="item"
				value="">
		</p>
		
		<p>
			<label for="year">year</label> <input id="year" name="year"
				value="">
		</p>
		
		<p>
			<label for="period">period</label> <input id="period" name="period"
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
				<td><c:out value="${it.getItem_name()}" /></td>

			</tr>
		</c:forEach>
		
		<p>
		
		<c:out value="${test}"/>
		</p>
</body>
</html>