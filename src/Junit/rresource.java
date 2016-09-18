package Junit;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import reserveresource.ResourceDAO;

public class rresource extends JUnitCore {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testReserve() throws SQLException {
		ResourceDAO rd = new ResourceDAO();
		int temp = rd.reserve("123456", "room", "01/01/2016", "2");
		Assert.assertTrue(temp == 1);
	}

}
