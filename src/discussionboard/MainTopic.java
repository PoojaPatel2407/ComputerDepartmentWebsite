package discussionboard;

public class MainTopic implements DiscussionBoard {

	DiscussionDAO dd = new DiscussionDAO();

	@Override
	public int postTopic(String id, String netid, String title,
			String content, String parentid, String datetime) throws Exception {
		return dd.postTopic(id, netid, title, content, parentid, datetime);
	}

	@Override
	public int deleteTopic(String id) throws Exception {
		return dd.deleteTopic(id);
	}
}
