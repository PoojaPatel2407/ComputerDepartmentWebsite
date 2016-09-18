package Junit;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import discussionboard.DiscussionDAO;

public class disspost extends JUnitCore {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testPostTopic() throws SQLException {
		DiscussionDAO dd = new DiscussionDAO();
		int temp = dd.postTopic("789", "123456", "aa", "aa", "0", "CURRENT_TIMESTAMP");
		Assert.assertTrue(temp==1);
	}

}
