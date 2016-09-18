<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="alumniinfo.AlumniDAO"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Alumni</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">


<h1>Change Alumni Info</h1>
<%
AlumniDAO ad = new AlumniDAO();
ArrayList<String> alumni = ad.getAlumni();

for(int i=0;i<alumni.size();i++) {
	String alumnis[] = alumni.get(i).split(":::::");
%>

<form action="ChangeAlumni" method="post">
<input type="text" name="aname" value="<%= alumnis[1] %>">
<input type="text" name="ainfo" value="<%= alumnis[2] %>">
<input type="text" name="aurl" value="<%= alumnis[3] %>">
<input type="hidden" name="aid" value="<%= alumnis[0] %>">
<input type="submit" value="Edit">
</form>

<br>
<% } %>
</div>
<%@ include file="footer.html" %>
</body>
</html>