package loginregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FSLogin implements login {
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

		String sql = "select * from facultystaffdetails where netid='" + netid + "'";

		try {

			ResultSet rs = s.executeQuery(sql);
			String thisnetid = "null";
			String thispassword = "null";
			String thisrole = "null";

			while (rs.next()) {
				thisnetid = rs.getString("netid");
				thispassword = rs.getString("password");
				thisrole = rs.getString("role");
			}

			if (thisnetid.equals(netid) && thispassword.equals(password)) {
				return thisrole;
			} else {
				return "null";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
