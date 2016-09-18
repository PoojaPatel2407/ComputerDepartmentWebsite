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

	<form role="form" action="AddExam" method="post">

		Exam Name: <input type="text" name="examname" placeholder="Exam Name"
			required> <br> <br> Exam Date: <input type="date"
			name="examdate" placeholder="Exam Date" required> <br> <br>
		<input type="submit" value="Create">
	</form>
</div>
<%@ include file="footer.html" %>
</body>
</html>