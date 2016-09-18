package Junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import loginregistration.FSLogin;

public class login extends JUnitCore {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCheckLogin() throws Exception {
		FSLogin fl = new FSLogin();
		String temp = fl.checkLogin("741258", "1234", "faculty");
		Assert.assertTrue(temp.equals("faculty"));
	}

}
