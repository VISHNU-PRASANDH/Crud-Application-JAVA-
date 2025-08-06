<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.project.POJO.UserPojo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
</head>
<body>
<% UserPojo user = (UserPojo) request.getAttribute("user"); %>

<h2>Update User</h2>
<form action="update" method="get">
    <label for="id">ID:</label>
    <input type="text" name="id" value="<%= user.getId() %>" readonly><br>

    <label for="name">Name:</label>
    <input type="text" name="name" value="<%= user.getName() %>" required><br>

    <label for="designation">Designation:</label>
    <input type="text" name="designation" value="<%= user.getDesignation() %>" required><br>

    <button type="submit">Update</button>
</form>

<br>
<a href="viewdata">⬅ Back</a>
</body>
</html>
