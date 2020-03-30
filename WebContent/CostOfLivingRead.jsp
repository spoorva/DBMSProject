<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find a User</title>
</head>
<body>
	<form action="colread" method="post">
		<h1>Search for an Item by ItemId</h1>
		<p>
			<label for="item">itemId</label> <input id="item" name="item"
				value="${fn:escapeXml(param.item)}">
		</p>
		<p>
			<input type="submit"> <br />
			<br />
			<br /> <span id="successMessage"><b>${messages.success}</b></span> <span
				id="test"><b>${messages.test}</b></span>
		</p>
	</form>

	<h1>Results :</h1>
	<table border="1">
		<tr>
			<th>Item</th>
			<th>ItemName</th>


		</tr>
		
		<c:forEach items="${i}" var="it">
			<tr>
		
				<td><c:out value="${it.getItem()}" /></td>
				<td><c:out value="${it.getItem_name()}" /></td>

			</tr>
		</c:forEach>

	</table>
</body>
</html>
