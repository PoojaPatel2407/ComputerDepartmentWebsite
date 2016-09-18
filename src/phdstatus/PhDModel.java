package phdstatus;

public class PhDModel {
	
	private String netid;
	private String fname;
	private String lname;
	private String status;

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PhDModel(String netid, String fname, String lname, String status) {
		super();
		this.netid = netid;
		this.fname = fname;
		this.lname = lname;
		this.status = status;
	}

}
