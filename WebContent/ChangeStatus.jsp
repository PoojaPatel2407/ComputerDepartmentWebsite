<%@page import="java.util.ArrayList"%>
<%@page import="phdstatus.PhDDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="phdstatus.PhDModel"%>

<html>
<head>

<title>Edit</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">


<h1>Edit Student Status</h1>


		<%
			String netid = (String) session.getAttribute("netid");
			String type = (String) session.getAttribute("type");
			String netidstudent = request.getParameter("netidphd");
			
			System.out.println(netidstudent);

			PhDDAO pd = new PhDDAO();
			ArrayList<String> profile = pd.onePhDInfo(netidstudent);
			String temp[] = profile.get(0).split(":::::");

		%>


			<form action="UpdateStatus" method="post">
NetID:
					<input type="text" name="netidstudent1"
						value="<%= temp[0] %>"
						disabled="disabled">
Status: <input type="text" name="statusphd" value="<%= temp[3] %>" required>
								<input type="hidden" name="netidstudent"
						value="<%= temp[0] %>"
						class="form-email form-control" id="form-email">

				<input type="submit" value="Edit">
			</form>
</div>
<%@ include file="footer.html" %>		
</body>
</html>