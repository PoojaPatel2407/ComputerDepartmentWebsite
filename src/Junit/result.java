package Junit;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import exam.ExamDAO;

public class result extends JUnitCore {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddResult() throws SQLException {
		ExamDAO ed = new ExamDAO();
		int temp = ed.addResult("123", "asd", "123456123");
		Assert.assertTrue(temp == 1);
	}

}
