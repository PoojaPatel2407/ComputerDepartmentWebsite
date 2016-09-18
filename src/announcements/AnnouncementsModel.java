package announcements;

public class AnnouncementsModel {
	
	private String id;
	private String netid;
	private String content;
	private String atype;
	private String link;
	private String email;
	private String date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNetid() {
		return netid;
	}
	public void setNetid(String netid) {
		this.netid = netid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public AnnouncementsModel(String id, String netid, String content, String atype, String link, String email,
			String date) {
		super();
		this.id = id;
		this.netid = netid;
		this.content = content;
		this.atype = atype;
		this.link = link;
		this.email = email;
		this.date = date;
	}
	
	
}
