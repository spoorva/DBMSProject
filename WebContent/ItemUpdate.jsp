<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update an Item</title>
</head>
<body>
	<h1>Update Item</h1>
	<form action="itemupdate" method="post">
		<p>
			<label for="item">Item</label>
			<input id="item" name="item" value="${fn:escapeXml(param.item)}">
		</p>
		<p>
			<label for="item_name">New Item Name</label>
			<input id="item_name" name="item_name" value="${fn:escapeXml(param.item_name)}">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		
		<span id="successMessage"><b>${messages.success}</b></span>
		
	</p>
</body>
</html>