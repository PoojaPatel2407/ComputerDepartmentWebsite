package alumniinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlumniDAO {

	Connection conn = null;
	Statement s = null;

	public AlumniDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/departmentsite", "root", "");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int addAlumni(String aname, String ainfo, String aurl) {

		String sql = "insert into alumnidetail values(NULL, '" + aname + "', '" + ainfo + "', '" + aurl + "')";
		int temp = 0;
		try {
			temp = s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

	public int editAlumni(String id, String aname, String ainfo, String aurl) {

		String sql = "update alumnidetail set aname='" + aname + "', ainfo='" + ainfo + "', aurl='" + aurl
				+ "' where ID='" + id + "'";
		int temp = 0;
		try {
			temp = s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

	public ArrayList<String> getAlumni() {
		ArrayList<String> alumni = new ArrayList<>();

		String sql = "select * from alumnidetail";
		try {
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				String temp = rs.getString("ID") + ":::::" + rs.getString("aname") + ":::::" + rs.getString("ainfo") + ":::::"
						+ rs.getString("aurl");
				alumni.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alumni;
	}

}
