package loginregistration;

import loginregistration.DAO;
import loginregistration.registration;

public class InsertFacultyStaff implements registration {

	@Override
	public int addDetails(String netid, String password, String role, String fname, String lname, String year,
			String program, String major) throws Exception {

		DAO dao = new DAO();
		int temp = dao.addAccount(netid, password, role, fname, lname, year, program, major);
		
		if (temp == 1) {
			return 1;
		}

		return 0;
	}
}
