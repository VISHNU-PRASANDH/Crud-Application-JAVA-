<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.util.*" %>
<%@ page import="com.project.POJO.UserPojo" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
   <center><h1>View All User Data</h1></center>
    
<div class="container"> 
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Designation</th>
    </tr>
  </thead>
  <tbody>
       <% 
      List<UserPojo> alluser = (List<UserPojo>)request.getAttribute("alluser");

		for(UserPojo user:alluser)
		{ %>
		<tr>
           <th scope="row"><%= user.getId() %></th>
           <td><%= user.getName() %></td>
           <td><%= user.getDesignation() %></td>
           <td>
            <a href="edit?id=<%= user.getId() %>"><button class="btn btn-success">Update</button></a>
      		<a href="delete?id=<%= user.getId() %>"><button class="btn btn-warning">delete</button></a>
           </td>
        </tr>
        <%
		}
        %>
   </tbody>
   <div class="container mb-3">
   <a href="index.jsp" class="btn btn-primary">⬅ Back to Insert Page</a>
   </div>
		
</table>
</div>

   
   
</body>
</html>