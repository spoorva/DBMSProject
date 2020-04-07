<%--
  Created by IntelliJ IDEA.
  User: nandini jampala
  Date: 03-04-2020
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.db_repository"%>
<%@page import="dao.db_connect"%>
<%@page import="model.usfoodbeverage"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
if ("POST".equalsIgnoreCase(request.getMethod())) {
    String series_id = request.getParameter("series_id");
    String year= request.getParameter("year");
    String period = request.getParameter("period");
    String value = request.getParameter("value");
    db_repository usfoodrepo = new db_repository();
    usfoodbeverage foodobj = new usfoodbeverage(series_id,year,period,value);
    try {
        Boolean insertresult = usfoodrepo.insert_beverages(foodobj);
        out.print("inserted successfully");
    }
    catch (Exception e) {
        e.printStackTrace();
    out.print(e.toString());
    }


} else {

    // Form was submitted.

        // It may be a GET request.
        }

%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>US Food and Beverages</title>
</head>
<body>
<div align="center">
<h1>Create food and beverage</h1>
</div>

<form action="usfoodbeverage.jsp" method="post">
    <div align="center">
    <p>
        <label for="series_id">series_id</label>
        <input id="series_id" name="series_id" value="">
    </p>
    <p>
        <label for="year">Year</label>
        <input id="year" name="year" value="">
    </p>
    <p>
        <label for="period">Period</label>
        <input id="period" name="period" value="">
    </p>
    <p>
        <label for="value">value</label>
        <input id="value" name="value" value="">
    </p>

    <button>

        <input type="submit" value="Save">
    </button>
    </div>

</form>
<br/><br/>
<p>
    <span id="successMessage"><b>${messages.success}</b></span>
</p>
</body>