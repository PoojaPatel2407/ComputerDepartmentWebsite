<%@ page import="exam.ExamModel"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="exam.ExamDAO"%>

<html>
<head>

</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">

	<h1>Courses</h1>
	<%
		ExamDAO ed = new ExamDAO();
		ArrayList<ExamModel> exam = ed.oneExam(request.getParameter("examid"));
	%>
	Exam Name: <%=exam.get(0).getExamname()%> <br><br>
			Exam Result: <%=exam.get(0).getResult()%>
	
	<%
		if ((exam.get(0).getNetid()).equals((String) session.getAttribute("netid"))) {
	%>

	<a href="EditResult.jsp?examid=<%=exam.get(0).getId()%>">Edit</a>

	<%
		}
	%>
	</div>
<%@ include file="footer.html" %>

</body>
</html>