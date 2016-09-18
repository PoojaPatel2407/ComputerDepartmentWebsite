package announcements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnnouncementsDAO {

	Connection conn = null;
	Statement s = null;

	public AnnouncementsDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/departmentsite", "root", "");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int add(String netid, String content, String atype, String alink, String aemail, String adate)
			throws SQLException {

		String sql = "INSERT INTO announcements VALUES (NULL, '" + netid + "', '" + content + "', '" + atype + "', '"
				+ alink + "', '" + aemail + "', '" + adate + "');";

		int temp = s.executeUpdate(sql);
		if (temp == 1) {
			return 1;
		}

		return 0;

	}

	public int change(String id, String netid, String content, String atype, String alink, String aemail)
			throws SQLException {

		String query = "update announcements set content='" + content + "', atype='" + atype + "', aemail='" + aemail
				+ "',alink='" + alink + "' where id='" + id + "';";

		int temp =s.executeUpdate(query);
		if (temp == 1) {
			return 1;
		}

		return 0;
	}

	public int remove(String id) throws SQLException {

		String query = "delete from announcements where ID='" + id + "';";

		int temp = s.executeUpdate(query);
		if (temp == 1) {
			return 1;
		}

		return 0;
	}

	public ArrayList<AnnouncementsModel> allAnnouncement() throws SQLException {

		ArrayList<AnnouncementsModel> announcement = new ArrayList<>();

		String query = "select * from announcements ORDER BY adate";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			AnnouncementsModel am = new AnnouncementsModel(rs.getString("ID"), rs.getString("netid"),
					rs.getString("content"), rs.getString("atype"), rs.getString("alink"), rs.getString("aemail"),
					rs.getString("adate"));

			announcement.add(am);
		}

		return announcement;
	}

}
