<%@page import="java.util.ArrayList"%>
<%@page import="announcements.AnnouncementsDAO"%>
<%@page import="java.sql.SQLException"%>

<html>
<head>
<title>Edit</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">

<form role="form" action="ChangeAnnouncement" method="post">

				<input type="hidden" name="id"
					value="<%=request.getParameter("id")%>"> <input
					type="hidden" name="atype"
					value="<%=request.getParameter("type")%>">
<br><br>
					<input type="text" name="content" placeholder="Title"
						value="<%=request.getParameter("announcement")%>"
						required>



				<%
					if ((request.getParameter("type")).equals("job")) {
				%>

				<br><br>
					<input type="email" name="aemail"
						value="<%=request.getParameter("email")%>"
						class="form-email form-control" id="form-email" required>
									<input type="text" name="alink" class="form-email form-control"
						value="<%=request.getParameter("link")%>" id="form-email"
						required>
					
				

				<%
					}
				%>
<br><br>
				<input type="submit" class="btn btn-lg btn-default" value="Edit">
			</form>
			</div>
<%@ include file="footer.html" %>
</body>
</html>