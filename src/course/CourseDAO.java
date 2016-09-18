package course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseDAO {
	
	Connection conn = null;
	Statement s = null;

	public CourseDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/departmentsite", "root", "");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<CourseModel> allCourses() throws SQLException {

		ArrayList<CourseModel> courses = new ArrayList<>();
		String query = "select * from course";

		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			CourseModel cvm = new CourseModel(rs.getString("cid"), rs.getString("cname"), rs.getString("cinfo"),
					rs.getString("cnetid"), rs.getString("cterm"));
			courses.add(cvm);
		}

		return courses;
	}

	public int changeCourseInfo(String coursenumber, String courseinfo) throws SQLException {

		String query = "update course set cinfo='" + courseinfo + "' where cid='" + coursenumber + "';";

		System.out.println(query);

		if (s.executeUpdate(query) == 1) {
			return 1;
		}

		return 0;
	}

	public int addCourse(String cnumber, String cname, String netid, String cinfo, String cterm) throws SQLException {

		String query = "INSERT INTO course VALUES ('" + cnumber + "', '" + cname + "', '" + netid + "', '" + cinfo
				+ "', '" + cterm + "');";

		if (s.executeUpdate(query) == 1) {
			return 1;
		}

		return 0;
	}

	public int makeMyCourse(String cid, String netid) throws SQLException {

		String query = "update course set cnetid='" + netid + "' where cid='" + cid + "';";

		if (s.executeUpdate(query) == 1) {
			return 1;
		}

		return 0;
	}
}
