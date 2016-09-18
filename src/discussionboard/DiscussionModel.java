package discussionboard;

public class DiscussionModel {

	private String id;
	private String netid;
	private String title;
	private String details;
	private String parentid;
	private String datetime;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getdetails() {
		return details;
	}

	public void setdetails(String details) {
		this.details = details;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public DiscussionModel(String id, String netid, String title,
			String details, String parentid, String datetime) {
		super();
		this.id = id;
		this.netid = netid;
		this.title = title;
		this.details = details;
		this.parentid = parentid;
		this.datetime = datetime;
	}

}
