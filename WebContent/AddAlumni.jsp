<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumni</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">
<h1>Add Alumni</h1>

<form action="AddAlumni" method="post">
<input type="text" name="aname" placeholder="Name"> <br> <br>
<textarea rows="3" cols="20" name="ainfo" placeholder="Info"></textarea> <br> <br>
<input type="text" name="aurl" placeholder="URL"> <br> <br>
<input type="submit" value="Add">
</form>
</div>
<%@ include file="footer.html" %>
</body>
</html>