package Junit;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import exam.ExamDAO;

public class cexam extends JUnitCore {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddExam() throws SQLException {
		ExamDAO ed = new ExamDAO();
		int temp = ed.addExam("ooo", "01/01/2016", "123456");
		Assert.assertTrue(temp == 1);
	}

}
