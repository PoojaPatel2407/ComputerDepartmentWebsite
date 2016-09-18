<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">

<form action="AddCourse" method="post">
Course Number: <input type="text" name="cnumber"> <br><br>
Course Name: <input type="text" name="cname"> <br><br>
Term: <input type="text" name="cterm">  <br><br>
<input type="submit" value="Create">
</form>
</div>
<%@ include file="footer.html" %>
</body>
</html>