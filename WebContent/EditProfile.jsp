<%@page import="java.util.ArrayList"%>
<%@page import="database.DAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="edit.GetProfileModel"%>

<html>
<head>

<title>Edit</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">


	<%
		String netid = (String) session.getAttribute("netid");
		String type = (String) session.getAttribute("type");

		DAO dao = new DAO();
		ArrayList<GetProfileModel> profile = new ArrayList<>();

		try {
			if (type.equals("student")) {
				profile = dao.getStudentProfile(netid);
			} else {
				profile = dao.getFacultyProfile(netid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	%>


	<div class="form-bottom">
		<form role="form" action="EditProfile" method="post">

			<div class="form-group">
				<input type="text" name="fname" placeholder="Title"
					value="<%=profile.get(0).getFname()%>"
					required>
				<p style="color: red"></p>
			</div>

			<div class="form-group">
				<input type="text" name="lname" placeholder="Title"
					value="<%=profile.get(0).getLname()%>"
					required>
				<p style="color: red"></p>
			</div>

			<div class="form-group">
				<input type="password" name="password" placeholder="Password"
					required>
				<p style="color: red"></p>
			</div>

			<%
				if (type.equals("1")) {
			%>

			<div class="form-group">
				<input type="text" name="year" placeholder="Title"
					value="<%=profile.get(0).getYearofadmission()%>"
					required>
				<p style="color: red"></p>
			</div>

			<div class="form-group">
				<label style="color: white" class="" for="program">Program</label> <select
					name="program">
					<%
						if ((profile.get(0).getProgram()).equals("BA")) {
					%>
					<option value="BA" selected>BA</option>
					<%
						} else {
					%>
					<option value="BA">BA</option>
					<%
						}
					%>
					<%
						if ((profile.get(0).getProgram()).equals("BS")) {
					%>
					<option value="BS" selected>BS</option>
					<%
						} else {
					%>
					<option value="BS">BS</option>
					<%
						}
							if ((profile.get(0).getProgram()).equals("MS")) {
					%>
					<option value="MS" selected>MS</option>
					<%
						} else {
					%>
					<option value="MS">MS</option>
					<%
						}
							if ((profile.get(0).getProgram()).equals("PhD")) {
					%>
					<option value="PhD" selected>PhD</option>
					<%
						} else {
					%>
					<option value="PhD">Phd</option>
					<%
						}
					%>
				</select>
			</div>

			<div class="form-group">
				<label style="color: white" class="" for="major">Major</label> <input
					type="text" name="major" placeholder="Title"
					value="<%=profile.get(0).getMajor()%>"
					required>
				<p style="color: red"></p>
			</div>

			<div class="form-group">
				<label style="color: white" class="" for="major">Advisor
					Name</label> <input type="text" name="advisorname"
					value="<%=profile.get(0).getAdvisorname()%>"
					required>
				<p style="color: red"></p>
			</div>

			<div class="form-group">
				<label style="color: white" class="" for="major">Advisor
					number</label> <input type="text" name="advisornumber"
					value="<%=profile.get(0).getAdvisornumber()%>"
					required>
				<p style="color: red"></p>
			</div>

			<div class="form-group">
				<label style="color: white" class="" for="major">Advisor
					Email</label> <input type="email" name="advisoremail"
					value="<%=profile.get(0).getAdvisoremail()%>"
					required>
				<p style="color: red"></p>
			</div>

			<%
				}
			%>

			<input type="submit" class="btn btn-lg btn-default" value="Edit">
		</form>
	</div>
	</div>
	</div>
<%@ include file="footer.html" %>

</body>
</html>