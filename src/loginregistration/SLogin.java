package loginregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SLogin implements login {
	public String checkLogin(String netid, String password, String type) throws Exception {

		Connection conn = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/departmentsite", "root", "");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "select * from studentdetails where netid='" + netid + "'";

		try {

			ResultSet rs = s.executeQuery(sql);
			String thisnetid = "null";
			String thispassword = "null";

			while (rs.next()) {
				thisnetid = rs.getString("netid");
				thispassword = rs.getString("password");
			}

			if (thisnetid.equals(netid) && thispassword.equals(password)) {
				return "student";
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
