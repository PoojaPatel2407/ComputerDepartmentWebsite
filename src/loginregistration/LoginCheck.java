package loginregistration;

import loginregistration.FSLogin;
import loginregistration.login;
import loginregistration.SLogin;

public class LoginCheck {

	public String LoginDetailsCheck(String netid, String password, String role) throws Exception {

		login login;

		if (role.equals("student")) {
			login = new SLogin();
		} else {
			login = new FSLogin();
		}

		String temp = login.checkLogin(netid, password, role);
		return temp;
	}

}
