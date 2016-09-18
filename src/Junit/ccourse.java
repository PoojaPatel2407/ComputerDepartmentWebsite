package Junit;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import course.CourseDAO;

public class ccourse extends JUnitCore {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddCourse() throws SQLException {
		CourseDAO ad = new CourseDAO();
		int temp = ad.addCourse("it6998", "asd", "124561", "", "Spring 2016");
		Assert.assertTrue(temp==1);
	}

}
