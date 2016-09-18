<%@page import="java.io.PrintWriter"%>
<%@ page import="java.util.*"%>
<%@ page import="reserveresource.ResourceDAO"%>

<html>
<head>

<title>Reserve Resource</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">
<h1>Reserve Resource</h1>
			<%
			ResourceDAO dao = new ResourceDAO();
				ArrayList<String> resource = dao.getResource();
			for(int i=0;i<resource.size();i++) {
			
			String name[] = (resource.get(i)).split(":::::");
			%>


<a href="MakeReservation2.jsp?rname=<%= name[1] %>"><%= name[0] %></a>
								
					
<% } %>
</div>
<%@ include file="footer.html" %>
</body>
</html>