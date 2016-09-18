<%@ page import="exam.ExamModel"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="exam.ExamDAO"%>

<html>
<head>

<title>Result</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">
	<h1>Courses</h1>
	<%
		ExamDAO ed = new ExamDAO();
		ArrayList<ExamModel> exam = ed.allExams();
	%>

	Exam Name
	<br>
	<%
		for (int i = 0; i < exam.size(); i++) {
	%>

	<a href="ViewResultDetails.jsp?examid=<%=exam.get(i).getId()%>"><%=exam.get(i).getExamname()%></a>
	<br>
	<%
		}
	%>
	</div>
<%@ include file="footer.html" %>

</body>
</html>