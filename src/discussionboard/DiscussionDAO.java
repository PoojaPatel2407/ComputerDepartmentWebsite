package discussionboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiscussionDAO {

	Connection conn = null;
	Statement s = null;

	public DiscussionDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/departmentsite", "root", "");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int postTopic(String id, String netid, String title, String details, String pid, String datetime)
			throws SQLException {

		String query = "INSERT INTO discussion VALUES (NULL, '" + netid + "', '" + title + "', '" + details + "', '"
				+ pid + "', CURRENT_TIMESTAMP);";

		System.out.println(query);

		int temp = s.executeUpdate(query);
		if (temp == 1) {
			return 1;
		}

		return 0;
	}

	public int deleteTopic(String id) throws SQLException {

		String query = "delete from discussion where ID='" + id + "';";

		int temp = s.executeUpdate(query);
		if (temp == 1) {
			return 1;
		}

		return 0;
	}

	public int editContent(String id, String title, String details) throws SQLException {

		String query = "update discussion set title='" + title + "', details='" + details + "' where id='" + id + "';";

		int temp = s.executeUpdate(query);
		if (temp == 1) {
			return 1;
		}

		return 0;
	}

	public List<DiscussionModel> getTopics() throws SQLException {

		String query = "select * from discussion";
		ResultSet rs = s.executeQuery(query);
		List<DiscussionModel> dt = new ArrayList<>();

		while (rs.next()) {
			DiscussionModel dm = new DiscussionModel(rs.getString("id"), rs.getString("netid"), rs.getString("title"),
					rs.getString("details"), rs.getString("pid"), rs.getString("datetime"));
			dt.add(dm);
		}

		return dt;

	}

}
