<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Create Item</h1>
	<form action="itemcreate" method="post">
		<p>
			<label for="item">Item</label>
			<input id="item" name="item" value="">
		</p>
		<p>
			<label for="item_name">ItemName</label>
			<input id="item_name" name="item_name" value="">
		</p>
		<p>
			<label for="display_level">DisplayLevel</label>
			<input id="display_level" name="display_level" value="">
		</p>
		<p>
			<label for="selectable">Selectable</label>
			<input id="selectable" name="selectable" value="">
		</p>
		
		<p>
			<label for="sort_sequence">SortSequence</label>
			<input id="sort_sequence" name="sort_sequence" value="">
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