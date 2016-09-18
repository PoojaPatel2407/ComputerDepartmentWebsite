<%@page import="reserveresource.ResourceDAO"%>
<%@page import="java.util.ArrayList"%>
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
		ResourceDAO rd = new ResourceDAO();
System.out.println((String) session.getAttribute("netid"));
		ArrayList<String> reservation = rd.getMyResource((String) session.getAttribute("netid"));
		for (int i = 0; i < reservation.size(); i++) {
			String temp[] = reservation.get(i).split(":::::");
	%>
	
	<p>Name: <%= temp[1] %></p>
	<p>Date: <%= temp[2] %></p>
	<% int temp1=(Integer.parseInt(temp[3])+6); int temp2 = temp1+2; %>
	<p>Time Slot: <%= temp1 %> - <%=temp2 %></p>
	
	<form action="RemoveReservation" method="post">
	<input type="hidden" value="<%=temp[0]%>" name="rid">
	<input type="submit" value="Cancel">
	</form>
	
	<%
		}
	%>
	</div>
<%@ include file="footer.html" %>
</body>
</html>