package discussionboard;

public interface DiscussionBoard {
	public int postTopic(String id, String netid, String title,
			String details, String pid, String datetime) throws Exception;

	public int deleteTopic(String id) throws Exception;
}
