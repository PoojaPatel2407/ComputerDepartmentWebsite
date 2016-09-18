package Junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import database.DAO;

public class register extends JUnitCore {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddAccount() {
		DAO d = new DAO();
		int temp = d.addAccount("787878", "123", "faculty", "test", "test", "2015", "PhD", "cs");
		Assert.assertTrue(temp == 1);
	}

}
