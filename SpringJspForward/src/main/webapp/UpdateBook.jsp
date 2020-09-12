<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Update Book</h2>
	
	<form action="updateBook" method="post">
		Book Id:<input type="text" name="bookId">
  <br><br>
  
  Book Name:<input type="text" name="bookName">
  <br><br>
  
  Author:<input type="text" name="author">
  <br><br>
  
  Publisher:<input type="text" name="publisher">
  <br><br>
  
  <input type="submit" value="Update">
  
	</form>
</body>
</html>