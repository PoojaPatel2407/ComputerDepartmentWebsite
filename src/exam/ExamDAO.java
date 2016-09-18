package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExamDAO {
	Connection conn = null;
	Statement s = null;

	public ExamDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/departmentsite", "root", "");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int addResult(String examname, String result, String id) throws SQLException {

		String query = "update results set examname='" + examname + "', result='" + result + "' where ID='" + id + "'";

		int temp = s.executeUpdate(query);
		if (temp == 1) {
			return 1;
		}

		return 0;
	}

	public ArrayList<ExamModel> allExams() throws SQLException {

		ArrayList<ExamModel> result = new ArrayList<>();

		String query = "select * from results";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			ExamModel erm = new ExamModel(rs.getString("ID"), rs.getString("examname"), rs.getString("examdate"),
					rs.getString("netid"), rs.getString("result"));

			result.add(erm);
		}

		return result;
	}

	public ArrayList<ExamModel> oneExam(String examid) throws SQLException {

		ArrayList<ExamModel> result = new ArrayList<>();

		String query = "select * from results where ID='" + examid + "'";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			ExamModel erm = new ExamModel(rs.getString("ID"), rs.getString("examname"), rs.getString("examdate"),
					rs.getString("netid"), rs.getString("result"));

			result.add(erm);
		}

		return result;
	}

	public int addExam(String examname, String examdate, String netid) throws SQLException {

		String query = "insert into results values(NULL, '" + examname + "','" + examdate + "','" + netid
				+ "', 'NULL')";
		
		int temp = s.executeUpdate(query);
		if (temp == 1) {
			return 1;
		}

		return 0;
	}
}
