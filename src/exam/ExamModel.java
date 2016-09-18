package exam;

public class ExamModel {
	private String id;
	private String examname;
	private String examdate;
	private String netid;
	private String result;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	public String getExamdate() {
		return examdate;
	}
	public void setExamdate(String examdate) {
		this.examdate = examdate;
	}
	public String getNetid() {
		return netid;
	}
	public void setNetid(String netid) {
		this.netid = netid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public ExamModel(String id, String examname, String examdate, String netid, String result) {
		super();
		this.id = id;
		this.examname = examname;
		this.examdate = examdate;
		this.netid = netid;
		this.result = result;
	}
	
}
