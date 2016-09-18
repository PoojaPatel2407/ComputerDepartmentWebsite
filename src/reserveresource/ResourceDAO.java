package reserveresource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ResourceDAO {

	Connection conn = null;
	Statement s = null;

	public ResourceDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/departmentsite", "root", "");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int findResource(String rname) throws SQLException {

		String sql = "select * from resourcedetail where rname='" + rname + "'";
		ResultSet rs = s.executeQuery(sql);
		String name = "";
		while (rs.next()) {
			name = rs.getString("rname");
		}

		if (name.equals(rname)) {
			return 0;
		}

		return 1;
	}

	public int addResource(String rname, String rtype, String rinfo) throws SQLException {

		String sql = "insert into resourcedetail values(NULL,'" + rname + "','" + rtype + "')";
		int temp = s.executeUpdate(sql);
		if (temp == 1) {
			return 1;
		}

		return 0;
	}

	public ArrayList<String> getResource() throws SQLException {
		ArrayList<String> resourcelist = new ArrayList<>();

		String sql = "select * from resourcedetail";
		ResultSet rs = s.executeQuery(sql);

		while (rs.next()) {
			String resource = rs.getString("rname") + ":::::" + rs.getString("rtype");
			resourcelist.add(resource);
		}

		return resourcelist;
	}

	public ArrayList<String> getTime(String rname, String rdate) throws SQLException {
		ArrayList<String> reservation = new ArrayList<>();

		String sql = "select * from reservationdetail where rdate='" + rdate + "' and rname='" + rname + "'";
		ResultSet rs = s.executeQuery(sql);

		while (rs.next()) {
			String temp = rs.getString("rtime");
			reservation.add(temp);
		}
		return reservation;
	}

	public int reserve(String netid, String rname, String rdate, String rtime) throws SQLException {

		String sql = "insert into reservationdetail values(NULL,'" + netid + "','" + rname + "','" + rdate + "','"
				+ rtime + "')";

		if (s.executeUpdate(sql) == 1) {
			return 1;
		}

		return 0;
	}

	public int cancel(String rid) throws SQLException {

		String sql = "delete from reservationdetail where id='" + rid + "'";

		if (s.executeUpdate(sql) == 1) {
			return 1;
		}

		return 0;
	}

	public ArrayList<String> getMyResource(String netid) throws SQLException {
		ArrayList<String> resourcelist = new ArrayList<>();

		String sql = "select * from reservationdetail where netid='" + netid + "'";
		ResultSet rs = s.executeQuery(sql);

		while (rs.next()) {
			String resource = rs.getString("id") + ":::::" + rs.getString("rname") + ":::::" + rs.getString("rdate")
					+ ":::::" + rs.getString("rtime");
			resourcelist.add(resource);
		}

		return resourcelist;
	}

}
