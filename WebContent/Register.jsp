<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<script type="text/javascript">
	function dField() {
		document.getElementsByName("year")[0].disabled = true;
		document.getElementsByName("program")[0].disabled = true;
		document.getElementsByName("major")[0].disabled = true;
	}
	function eField() {
		document.getElementsByName("year")[0].disabled = false;
		document.getElementsByName("program")[0].disabled = false;
		document.getElementsByName("major")[0].disabled = false;
	}
</script>
</head>
<body>
<%@ include file="header.html" %>

<div style="margin-left: 350px; margin-top: 100px">
<h1>Sign up now</h1>

	<form role="form" action="CreateRegistration" method="post">
		NetID: <input type="text" name="netid" placeholder="NetID" required> <br><br>
		First name: <input type="text" name="fname" placeholder="First name"
			required><br><br> Last name: <input type="text" name="lname"
			placeholder="Last name" required><br><br> Password: <input
			type="password" name="password" placeholder="Password" required><br><br>
		Role: <select name="role">
			<option value="student" onclick="eField()">Student</option><br>
			<option value="faculty" onclick="dField()">Faculty</option><br>
			<option value="staff" onclick="dField()">Staff</option><br>
		</select><br><br> Year of Admission: <input type="text" name="year"
			placeholder="Year of Admission" required><br><br>
		
			Program: <select
				class="form-control" name="program">
				<option value="BA">BA</option><br>
				<option value="BS">BS</option><br>
				<option value="MS">MS</option><br>
				<option value="PhD">PhD</option>
			</select>
<br><br>
			Major: <input
				type="text" name="major" placeholder="Program" required>
		<br><br>
		<input type="submit" value="Register">
	</form>
	</div>
	<br><br><br>
<%@ include file="footer.html" %>
</body>
</html>