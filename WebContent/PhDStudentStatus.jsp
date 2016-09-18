<%@ page import="phdstatus.PhDModel"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="phdstatus.PhDDAO"%>

<html>
<head>
<title>PhD Student Status</title>
</head>
<body>
<%@ include file="header.html" %>
<%@ include file="menu.html" %>

<div style="margin-left: 350px; margin-top: 100px">
<h1>PhD Students</h1>

			<%
				PhDDAO pd = new PhDDAO();
				ArrayList<PhDModel> phdstudnet = pd.allPhDInfo();
			%>
			<%
					for (int i = 0; i < phdstudnet.size(); i++) {
				%>
					NetID: <a href="ChangeStatus.jsp?netidphd=<%=phdstudnet.get(i).getNetid()%>"><%=phdstudnet.get(i).getNetid()%></a>
					<br><br>
					First Name: <%=phdstudnet.get(i).getFname()%>
					<br><br>
					Last Name: <%=phdstudnet.get(i).getLname() %>
					<br><br>
					Status: <%=phdstudnet.get(i).getStatus() %>
				
				
				<%
					}
				%>
			</table>

		</div>
<%@ include file="footer.html" %>
</body>
</html>