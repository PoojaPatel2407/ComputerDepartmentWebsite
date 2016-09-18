package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edit.GetProfileModel;

public class DAO {

	Connection conn = null;
	Statement s = null;

	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/departmentsite", "root", "");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String Type(String netid) {
		String sql = "select * from logindetails where netid='" + netid + "'";

		try {

			ResultSet rs = s.executeQuery(sql);
			String thisnetid = "null";
			String type = "null";

			while (rs.next()) {
				thisnetid = rs.getString("Netid");
				type = rs.getString("Type");
			}

			if (thisnetid.equals(netid)) {
				return type;
			} else {
				return "0";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";

	}

	public int addAccount(String netid, String password, String role, String fname, String lname, String year,
			String program, String major) {

		String sql = "null";
		try {
			if (role.equals("student")) {
				sql = "INSERT INTO studentdetails VALUES ('" + netid + "', '" + password + "', '" + fname + "', '"
						+ lname + "', '" + year + "', '" + program + "', '" + major + "','null')";
			} else {
				sql = "INSERT INTO facultystaffdetails VALUES ('" + netid + "', '" + password + "', '" + fname + "', '"
						+ lname + "', '" + role + "')";
			}

			if (s.executeUpdate(sql) == 1) {

					return 1;
			}
				return 0;
			

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean AvailNetID(String netid) {

		String query = "select * from logindetails where netid = '" + netid + "'";

		try {
			ResultSet rs = s.getResultSet();
			rs = s.executeQuery(query);
			String thisnetid = "null";
			if (rs.next()) {
				thisnetid = rs.getString("netid");
			}

			if (netid.equals(thisnetid))
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<GetProfileModel> getStudentProfile(String netid) throws SQLException {

		String query = "select * from studentdetails where Netid='" + netid + "';";
		ResultSet rs = s.executeQuery(query);
		ArrayList<GetProfileModel> profile = new ArrayList<GetProfileModel>();

		while (rs.next()) {
			GetProfileModel gpm = new GetProfileModel(rs.getString("Netid"), rs.getString("Fname"),
					rs.getString("Lname"), rs.getString("Year"), rs.getString("Major"), rs.getString("Program"),
					rs.getString("Advisorname"), rs.getString("Advisornumber"), rs.getString("Advisoremail"));
			profile.add(gpm);
		}

		return profile;

	}

	public ArrayList<GetProfileModel> getFacultyProfile(String netid) throws SQLException {

		String query = "select * from facultystaffdetails where Netid='" + netid + "';";
		ResultSet rs = s.executeQuery(query);
		ArrayList<GetProfileModel> profile = new ArrayList<GetProfileModel>();

		while (rs.next()) {
			GetProfileModel gpm = new GetProfileModel(rs.getString("Netid"), rs.getString("Fname"),
					rs.getString("Lname"), "null", "null", "null");
			profile.add(gpm);
		}

		return profile;

	}

	public ArrayList<GetProfileModel> getStaffProfile(String netid) throws SQLException {

		String query = "select * from staff where Netid='" + netid + "';";
		ResultSet rs = s.executeQuery(query);
		ArrayList<GetProfileModel> profile = new ArrayList<GetProfileModel>();

		while (rs.next()) {
			GetProfileModel gpm = new GetProfileModel(rs.getString("Netid"), rs.getString("Fname"),
					rs.getString("Lname"), "null", "null", "null");
			profile.add(gpm);
		}

		return profile;

	}

	public boolean updateStudentProfile(String netid, String password, String fname, String lname, String year,
			String program, String major, String advisorname, String advisornumber, String advisoremail)
					throws SQLException {

		String query = "update studentdetails set Fname='" + fname + "', Lname='" + lname + "', Year='" + year
				+ "', Program='" + program + "', Major='" + major + "', Advisorname='" + advisorname
				+ "', Advisornumber='" + advisornumber + "', Advisoremail='" + advisoremail + "' where Netid='" + netid
				+ "';";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean updateStaffProfile(String netid, String password, String fname, String lname) throws SQLException {

		String query = "update facultystaffdetails set Fname='" + fname + "', Lname='" + lname + "', password='"
				+ password + "' where Netid='" + netid + "';";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean addJobAnnouncement(String id, String netid, String announcement, String type, String email,
			String link, String date) throws SQLException {

		String query = "INSERT INTO announcement VALUES ('" + id + "', '" + netid + "', '" + announcement + "', '"
				+ type + "', '" + email + "', '" + link + "', '" + date + "');";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean addEventNewsAnnouncement(String id, String netid, String announcement, String type, String date)
			throws SQLException {

		String query = "INSERT INTO announcement VALUES ('" + id + "', '" + netid + "', '" + announcement + "', '"
				+ type + "', 'null', 'null', '" + date + "');";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean editJobAnnouncement(String id, String netid, String announcement, String type, String email,
			String link, String date) throws SQLException {

		String query = "update announcement set Announcement='" + announcement + "', Type='job', Email='" + email
				+ "',Link='" + link + "' where Netid='" + netid + "';";

		System.out.println(query);

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean editEventNewsAnnouncement(String id, String netid, String announcement, String type, String date)
			throws SQLException {

		String query = "update announcement set Announcement='" + announcement + "', Type='" + type
				+ "', Email='null',Link='null' where ID='" + id + "';";

		System.out.println(query);

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean deleteAnnouncement(String id) throws SQLException {

		String query = "delete from announcement where ID='" + id + "';";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean registerExam(String examid, String netid) throws SQLException {

		String query = "select * from exam where ID='" + examid + "'";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			String registered = rs.getString("Registration");
			registered = registered + "," + netid;

			query = "update exam set Registration='" + registered + "' where ID='" + examid + "';";

			if (s.executeUpdate(query) == 1) {
				return true;
			}
		}
		return false;
	}
}
