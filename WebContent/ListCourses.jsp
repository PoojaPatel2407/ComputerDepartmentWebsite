<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="course.CourseModel"%>
<%@ page import="course.CourseDAO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">


			<%
			CourseDAO dao = new CourseDAO();
				ArrayList<CourseModel> courseinfo = dao.allCourses();
			%>
			
				<%
					for (int i = 0; i < courseinfo.size(); i++) {
				%>
			
					Course Number: <%=courseinfo.get(i).getCid()%> <br><br>
					Course Name: <%=courseinfo.get(i).getCname()%> <br><br>
					
						<%
							if (!(courseinfo.get(i).getCnetid()).equals("null")) {
						%> Instructor: <%=courseinfo.get(i).getCnetid()%> <%
 	} else {
 %> Instructor: <a href="CreateInstructor?cid=<%=courseinfo.get(i).getCid()%>">Make
							me Instructor</a> <%
 	}
 %><br><br>

					Term: <%=courseinfo.get(i).getCterm()%><br><br>
					
						<%
							if ((courseinfo.get(i).getCnetid()).equals(session.getAttribute("netid"))) {
						%>
						<form action="EditMyCourse" method="post">
							<input type="hidden" name="coursenumber"
								value="<%=courseinfo.get(i).getCid()%>" required> <input
								type="text" value="<%=courseinfo.get(i).getCinfo()%>" 
								name="courseinfo" required> <input type="submit"
								value="Edit">
						</form> <%
 	} else {
 %> Info: <%=courseinfo.get(i).getCinfo()%> <%
 	}
 %>

<br><br>
				<%
					}
				%>
	</div>
<%@ include file="footer.html" %>
</body>
</html>