<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Update Item</h1>
	<form action="foodupdate" method="post">
		<p>
			<label for="item">Item</label>
			<input id="item" name="item" value=""}">
		</p>
		<p>
			<label for="value">New Item Name</label>
			<input id="value" name="value" value="">
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