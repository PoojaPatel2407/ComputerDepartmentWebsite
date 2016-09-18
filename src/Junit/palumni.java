package Junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import alumniinfo.AlumniDAO;

public class palumni extends JUnitCore {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddAlumni() {
		AlumniDAO ad = new AlumniDAO();
		int temp = ad.addAlumni("plm", "asdadsa", "google.com");
		Assert.assertTrue(temp ==1);
	}

}
