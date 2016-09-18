package course;

public class CourseModel {

	private String cid;
	private String cname;
	private String cinfo;
	private String cnetid;
	private String cterm;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCinfo() {
		return cinfo;
	}

	public void setCinfo(String cinfo) {
		this.cinfo = cinfo;
	}

	public String getCnetid() {
		return cnetid;
	}

	public void setCnetid(String cnetid) {
		this.cnetid = cnetid;
	}

	public String getCterm() {
		return cterm;
	}

	public void setCterm(String cterm) {
		this.cterm = cterm;
	}

	public CourseModel(String cid, String cname, String cinfo, String cnetid, String cterm) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cinfo = cinfo;
		this.cnetid = cnetid;
		this.cterm = cterm;
	}
}
