package model;

public class Plan {

	private int pId;
	private String pName;
	private String pDescription;
	private String pBeginDate;
	private String pEndDate;
	private String pStatus;
	private int pFeedback;
	private String pFeedbackMsg;
	private int task_tId;
	private int user_uId;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public String getpBeginDate() {
		return pBeginDate;
	}

	public void setpBeginDate(String pBeginDate) {
		this.pBeginDate = pBeginDate;
	}

	public String getpEndDate() {
		return pEndDate;
	}

	public void setpEndDate(String pEndDate) {
		this.pEndDate = pEndDate;
	}

	public String getpStatus() {
		return pStatus;
	}

	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public int getpFeedback() {
		return pFeedback;
	}

	public void setpFeedback(int pFeedback) {
		this.pFeedback = pFeedback;
	}

	public String getpFeedbackMsg() {
		return pFeedbackMsg;
	}

	public void setpFeedbackMsg(String pFeedbackMsg) {
		this.pFeedbackMsg = pFeedbackMsg;
	}

	public int getTask_tId() {
		return task_tId;
	}

	public void setTask_tId(int task_tId) {
		this.task_tId = task_tId;
	}

	public int getUser_uId() {
		return user_uId;
	}

	public void setUser_uId(int user_uId) {
		this.user_uId = user_uId;
	}

}
