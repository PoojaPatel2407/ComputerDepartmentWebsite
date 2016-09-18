package announcements;

public interface Announcements {
	
	public int addAnnouncement(String netid, String content, String atype, String link, String email);
	public int changeAnnouncement(String id, String netid, String content, String atype, String link, String email);
	public int removeAnnouncement(String id);

}
