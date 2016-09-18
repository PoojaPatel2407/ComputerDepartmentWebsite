package discussionboard;

public class DiscussionBoardDetail {

	public int postContent(String id, String netid, String title, String details, String parentid, String datetime)
			throws Exception {

		if (parentid.equals("null")) {
			DiscussionBoard db = new MainTopic();
			return db.postTopic(id, netid, title, details, parentid, datetime);
		} else {
			DiscussionBoard db = new Reply();
			return db.postTopic(id, netid, title, details, parentid, datetime);
		}
	}

	public int deleteContent(String id, String parentid) throws Exception {
		if (parentid.equals("null")) {
			DiscussionBoard db = new MainTopic();
			return db.deleteTopic(id);
		} else {
			DiscussionBoard db = new Reply();
			return db.deleteTopic(id);
		}
	}

}
