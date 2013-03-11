package model;

public class Task {

	private int tId;
	private String tName;
	private String tDescription;
	private String tBeginDate;
	private String tEndDate;
	private String tRealBeginDate;
	private String tRealEndDate;
	private String tStatus;
	private int user_uId;
	private String user_uMgr;

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettDescription() {
		return tDescription;
	}

	public void settDescription(String tDescription) {
		this.tDescription = tDescription;
	}

	public String gettBeginDate() {
		return tBeginDate;
	}

	public void settBeginDate(String tBeginDate) {
		this.tBeginDate = tBeginDate;
	}

	public String gettEndDate() {
		return tEndDate;
	}

	public void settEndDate(String tEndDate) {
		this.tEndDate = tEndDate;
	}

	public String gettRealBeginDate() {
		return tRealBeginDate;
	}

	public void settRealBeginDate(String tRealBeginDate) {
		this.tRealBeginDate = tRealBeginDate;
	}

	public String gettRealEndDate() {
		return tRealEndDate;
	}

	public void settRealEndDate(String tRealEndDate) {
		this.tRealEndDate = tRealEndDate;
	}

	public String gettStatus() {
		return tStatus;
	}

	public void settStatus(String tStatus) {
		this.tStatus = tStatus;
	}

	public int getUser_uId() {
		return user_uId;
	}

	public void setUser_uId(int user_uId) {
		this.user_uId = user_uId;
	}

	public String getUser_uMgr() {
		return user_uMgr;
	}

	public void setUser_uMgr(String user_uMgr) {
		this.user_uMgr = user_uMgr;
	}

}
