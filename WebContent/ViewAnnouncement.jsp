<%@page import="announcements.AnnouncementsDAO"%>
<%@page import="announcements.AnnouncementsModel"%>
<%@page import="java.io.PrintWriter"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html lang="en">

<head>

</head>

<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">
	<h1>Announcement</h1>

	<%
		AnnouncementsDAO dao = new AnnouncementsDAO();
	%>




	<form action="AddAnnouncement" method="post">

		<textarea name="content" rows="3" placeholder="Announcement"></textarea>
		<br> <br> Type: <select name="atype">
			<option value="job" onclick="enableField()">Job</option>
			<option value="news" onclick="disableField()">News</option>
			<option value="event" onclick="disableField()">Event</option>
		</select> <br> <br> Email: <input type="text" placeholder="Email"
			name="aemail"> <br> <br> Link:<input type="text"
			placeholder="Link" name="alink"><br> <br> <input
			type="submit" value="Post">

	</form>

	<%
		ArrayList<AnnouncementsModel> announcementfeed = new ArrayList<>();
		announcementfeed = dao.allAnnouncement();

		for (int i = 0; i < announcementfeed.size(); i++) { %> <br><br><br> <%
		out.write(announcementfeed.get(i).getNetid()); %> <br> <%
		out.write(announcementfeed.get(i).getDate()); %> <br> <%
		out.println(announcementfeed.get(i).getContent()); %> <br> <%

			if ((announcementfeed.get(i).getAtype()).equals("job")) {

				out.println("<br><a href='" + announcementfeed.get(i).getEmail() + "'>"
						+ announcementfeed.get(i).getEmail() + "</a>");
				out.println("<br><a href='" + announcementfeed.get(i).getLink() + "'>"
						+ announcementfeed.get(i).getLink() + "</a>");

			}
			if ((announcementfeed.get(i).getNetid()).equals(((String) session.getAttribute("netid")))) {
	%>

	<form action="EditAnnouncement.jsp" method="post">
		<input type="hidden" name="id"
			value="<%=announcementfeed.get(i).getId()%>"> <input
			type="hidden" name="announcement"
			value="<%=announcementfeed.get(i).getContent()%>"> <input
			type="hidden" name="type"
			value="<%=announcementfeed.get(i).getAtype()%>"> <input
			type="hidden" name="email"
			value="<%=announcementfeed.get(i).getEmail()%>"> <input
			type="hidden" name="link"
			value="<%=announcementfeed.get(i).getLink()%>"> <input
			type="submit" value="Edit">
	</form>

	<form action="RemoveAnnouncement" method="get">
		<input type="hidden" name="id"
			value="<%=announcementfeed.get(i).getId()%>"><input
			type="submit" value="Delete">

		<%
			}
		%>

	</form>

	<%
		}
	%>
</div>
<%@ include file="footer.html" %>
</body>

</html>