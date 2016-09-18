<html>
<head>
<% if(!session.getAttribute("type").equals("staff")) {
	response.sendRedirect("home.jsp");
}
%>
<title>Create Resource</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">

	<h1>Create Resource</h1>

	<form action="AddResource" method="post">
		Resource Name: <input type="text" name="rname"
			placeholder="Resource Name" required> <br><br>
			Resource Type: <select
			class="form-control" name="rtype">
			<option value="Room">Room</option>
			<option value="Furniture">Furniture</option>
			<option value="Device">Device</option>
		</select> <br><br> <input type="submit" value="Create">
	</form>
	<p>${error_r}</p>
</div>
<%@ include file="footer.html" %>
</body>
</html>