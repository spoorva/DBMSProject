<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an Item</title>
</head>
<body>
	<h1>Create Item</h1>
	<form action="costoflivingcreate" method="post">
		<p>
			<label for="place">Place</label>
			<input id="place" name="place" value="">
		</p>
		<p>
			<label for="meal">Meal</label>
			<input id="meal" name="meal" value="">
		</p>
		<p>
			<label for="water">water</label>
			<input id="water" name="water" value="">
		</p>
		<p>
			<label for="milk">milk</label>
			<input id="milk" name="milk" value="">
		</p>
		
		<p>
			<label for="whitebread">whitebread</label>
			<input id="whitebread" name="whitebread" value="">
		</p>
		
		<p>
			<label for="eggs">eggs</label>
			<input id="eggs" name="eggs" value="">
		</p>
		
		<p>
			<label for="localcheese">localcheese</label>
			<input id="localcheese" name="localcheese" value="">
		</p>
		
		<p>
			<label for="chicken">chicken</label>
			<input id="chicken" name="chicken" value="">
		</p>
		
		<p>
			<label for="apples">apples</label>
			<input id="apples" name="apples" value="">
		</p>
		
		<p>
			<label for="oranges">oranges</label>
			<input id="oranges" name="oranges" value="">
		</p>
		
		<p>
			<label for="chicken">chicken</label>
			<input id="chicken" name="chicken" value="">
		</p>
		
		
		<p>
			<label for="potato">potato</label>
			<input id="potato" name="potato" value="">
		</p>
		
		
		<p>
			<label for="lettuce">lettuce</label>
			<input id="lettuce" name="lettuce" value="">
		</p>
		
		
		<p>
			<label for="cappuccino">cappuccino</label>
			<input id="cappuccino" name="cappuccino" value="">
		</p>
		
		
		<p>
			<label for="rice">rice</label>
			<input id="rice" name="rice" value="">
		</p>
		
		
		<p>
			<label for="tomato">tomato</label>
			<input id="tomato" name="tomato" value="">
		</p>
		
		
		<p>
			<label for="banana">banana</label>
			<input id="banana" name="banana" value="">
		</p>
		
		
		<p>
			<label for="onion">onion</label>
			<input id="onion" name="onion" value="">
		</p>
		
		
		<p>
			<label for="beef">beef</label>
			<input id="beef" name="beef" value="">
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