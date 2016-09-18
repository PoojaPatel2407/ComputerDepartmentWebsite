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

<%
String rname = request.getParameter("rname");
%>

<form action="GetTime" method="post">
<input type="hidden" value="<%= rname %>" name="rname">
<input type="date" placeholder="mm/dd/yyyy" name="rdate">
<input type="submit" value="Get Times">
</form>
</div>
<%@ include file="footer.html" %>
</body>
</html>