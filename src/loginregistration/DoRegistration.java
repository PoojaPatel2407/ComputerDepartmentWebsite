package loginregistration;

import loginregistration.InsertFacultyStaff;
import loginregistration.InsertStudent;
import loginregistration.registration;

public class DoRegistration {

	registration registration;

	public int insertRecord(String netid, String password, String role, String fname, String lname, String year,
			String program, String major) throws Exception {

		if (role.equals("student")) {
			registration = new InsertStudent();
		} else {
			registration = new InsertFacultyStaff();
		}

		int temp = registration.addDetails(netid, password, role, fname, lname, year, program, major);
		if (temp == 1) {
			return 1;
		}

		return 0;
	}

}
