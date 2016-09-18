package Junit;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import announcements.AnnouncementsDAO;

public class annopost extends JUnitCore {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAdd() throws SQLException {
		AnnouncementsDAO ad = new AnnouncementsDAO();
		int temp = ad.add("", "asd", "event", "", "", "CURRENT_TIMESTAMP");
		Assert.assertTrue(temp==1);
	}

}
