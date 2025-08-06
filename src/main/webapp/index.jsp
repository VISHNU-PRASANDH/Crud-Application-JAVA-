<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
   <div class="form-container">
    <h2>Add User</h2>
    <form action="insert" method="post">
      <label for="id">Id</label>
      <input type="number" name="id" id="id" required><br>

      <label for="name">Name</label>
      <input type="text" name="name" id="name" required><br>

      <label for="designation">Designation</label>
      <input type="text" name="designation" id="designation" required><br>

      <button type="submit" class="submit-btn">ADD</button>
    </form>

    <a href="viewdata"><button type="button" class="view-btn">View ALL DATA</button></a>
    
    
    
    
  </div>
</body>
</html>

