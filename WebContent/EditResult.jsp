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
	<h1>Edit Result</h1>
	<%
		ExamDAO ed = new ExamDAO();
		String id = request.getParameter("examid");
		System.out.println(id);
		ArrayList<ExamModel> exam = ed.oneExam(id);

		if (!(exam.get(0).getNetid()).equals(((String) session.getAttribute("netid")))) {
			response.sendRedirect("ViewResult.jsp");
		}
	%>

	<form role="form" action="AddResult" method="post">
		Exam Name: <input type="text" name="examname" placeholder="Exam Name"
			value="<%=exam.get(0).getExamname()%>" required> <br>
		<br> Exam Result:
		<textarea name="result" rows="3" placeholder="Result"><%=exam.get(0).getResult()%></textarea>
		<br>
		<br> <input type="hidden" name="id"
			value="<%=exam.get(0).getId()%>" required> <input
			type="submit" value="Edit Result">
	</form>

	<br>
	<br>
	</div>
<%@ include file="footer.html" %>

</body>
</html>