<%@page import="discussionboard.DiscussionDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="discussionboard.DiscussionModel"%>

<!DOCTYPE html>
<html lang="en">

<head>

</head>

<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">
	<%
		DiscussionDAO dd = new DiscussionDAO();
	%>
	<%
		out.println(session.getAttribute("netid"));
	%>
	<br>
	<%
		Date dt = new java.util.Date();

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		String date = sdf.format(dt);

		List<DiscussionModel> topics = dd.getTopics();
	%>
	<%
		out.println(date);
	%>
	<form action="PostTopic" method="post">
		<input type="text" placeholder="Title" name="title"> <br><br>
		<textarea name="content" rows="3" placeholder="Question"></textarea> <br><br>
		<input type="hidden" name="pid" value="null"> <input
			type="hidden" name="date" value="<%=date%>"> <input
			type="submit" value="Post"> <br><br>

	</form>
	<%
		for (int i = 0; i < topics.size(); i++) {
			if ((topics.get(i).getParentid()).equals("null")) {
	%>
	<%
		out.write(topics.get(i).getNetid());
	%>
	<br>
	<%
		out.write(topics.get(i).getDatetime());
	%>
	<br>
	<p>
		<%
			out.println(topics.get(i).getTitle());
		%>
	</p>
<br>
	<p>
		<%
			out.println(topics.get(i).getdetails());
		%>
	
	<form action="DeleteTopic" method="post">
		<input type="hidden" name="id" value="<%=topics.get(i).getId()%>">
		<input type="hidden" name="pid" value="0"> <input
			type="submit" id="deletebutton"
			 value="Delete"
			>
	</form>

	<form action="PostTopic" method="post">
		<input type="hidden" class="form-control" name="title" value="null" />
		<input type="text" class="form-control" name="content" /> <input
			name="pid" type="hidden" value="<%=topics.get(i).getId()%>">
		<input type="hidden" class="form-control" name="date"
			value="<%=date%>" /> <input type="submit" name="action"
			value="reply" />
	</form>
	<!-- Comment Start-->
	<%
		for (int j = 0; j < topics.size(); j++) {
					if (topics.get(j).getParentid().equals(topics.get(i).getId())) {
	%>
	<br>
	<%
		out.write(topics.get(j).getNetid());
	%>
	<br>
	<%
		out.write(topics.get(j).getdetails());
	%>


	<form action="DeleteTopic" method="post">
		<input type="hidden" name="id" value="<%=topics.get(j).getId()%>">
		<input type="hidden" name="pid"
			value="<%=topics.get(j).getParentid()%>"> <input
			type="submit" class="btn btn-primary btn-xs pull-right "
			value="Delete">
	</form>
	<%
		out.write(topics.get(j).getDatetime());
	%>
	<%
		}
				}
	%>
	<%
		}
		}
	%>
	</div>
<%@ include file="footer.html" %>
</body>

</html>