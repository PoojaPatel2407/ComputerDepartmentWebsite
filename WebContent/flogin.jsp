
<html>

<title>Login</title>

<body>
<%@ include file="header.html" %>

<div style="margin-left: 350px; margin-top: 100px">

	<h1>Login</h1>
	<form role="form" action="LoginAuth" method="post">
		NetID: <input type="text" name="netid" placeholder="Email" required>
		<br>
		<br> Password: <input type="password" name="password"
			placeholder="Password" required><br>
			<input type="hidden" name="role" value="facultystaff">
		<br> <input type="submit" value="Login">
		</td>
	</form>
<p>${error_l}</p>
</div>
<%@ include file="footer.html" %>
</body>
</html>