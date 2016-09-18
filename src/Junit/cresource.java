package Junit;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import reserveresource.ResourceDAO;

public class cresource extends JUnitCore {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddResource() throws SQLException {
		ResourceDAO rd = new ResourceDAO();
		int temp = rd.addResource("room4286", "room", "");
		Assert.assertTrue(temp == 1);
	}

}
