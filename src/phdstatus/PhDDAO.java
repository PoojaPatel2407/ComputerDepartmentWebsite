package phdstatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PhDDAO {

	Connection conn = null;
	Statement s = null;

	public PhDDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/departmentsite", "root", "");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<PhDModel> allPhDInfo() throws SQLException {

		ArrayList<PhDModel> info = new ArrayList<>();

		String query = "select * from studentdetails where program='PhD'";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			PhDModel pssm = new PhDModel(rs.getString("netid"), rs.getString("fname"), rs.getString("lname"),
					rs.getString("status"));

			info.add(pssm);
		}

		return info;
	}

	public ArrayList<String> onePhDInfo(String netid) throws SQLException {

		ArrayList<String> phd = new ArrayList<>();

		String query = "select * from studentdetails where netid='" + netid + "' and program='PhD'";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			String pssm = rs.getString("netid") + ":::::" + rs.getString("fname") + ":::::" + rs.getString("lname")
					+ ":::::" + rs.getString("status");

			phd.add(pssm);
		}

		return phd;
	}

	public int changeStatus(String netid, String status) throws SQLException {

		String query = "update studentdetails set status='" + status + "' where netid='" + netid + "';";

		int temp = s.executeUpdate(query);

		if (temp == 1) {
			return 1;
		}

		return 0;
	}
}
