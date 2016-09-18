<%@page import="java.util.Arrays"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page import="exam.ExamModel"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="exam.ExamDAO"%>

<html>
<head>

<title>Edit Exam Result</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">


	<%
		ExamDAO dao = new ExamDAO();
		ArrayList<ExamModel> exam = dao.allExams();
	%>

	

	<br>
	<br>
<%
			for (int i = 0; i < exam.size(); i++) {
		%>
			Exam Name: <%=exam.get(i).getExamname()%>    <br><br>
			Exam Date: <%=exam.get(i).getExamdate()%><br><br>
		
		<%
			}
		%>
</div>
<%@ include file="footer.html" %>


</body>
</html>