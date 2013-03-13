package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Plan;
import model.Task;

import org.apache.struts2.ServletActionContext;

import dao.interfaces.PlanDAO;
import dao.interfaces.TaskDAO;
import dao.interfaces.UserDAO;
import dao.utils.DAOFactory;

public class StfAction {

	private int planId;
	private int taskId;
	private int userId;
	private int userRole;
	private String planName;
	private String planDescription;
	private String planBeginDate;
	private String planEndDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public String getPlanBeginDate() {
		return planBeginDate;
	}

	public void setPlanBeginDate(String planBeginDate) {
		this.planBeginDate = planBeginDate;
	}

	public String getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	// 显示计划列表
	public String ShowPlanList() throws Exception {
		PlanDAO pDAO = null;
		UserDAO uDAO = null;
		TaskDAO tDAO = null;
		String retMess = "ShowPlanListFailed";

		try {
			pDAO = DAOFactory.getPlanDAOInstance();
			uDAO = DAOFactory.getUserDAOInstance();
			tDAO = DAOFactory.getTaskDAOInstance();

			HttpServletRequest request = ServletActionContext.getRequest();

			if (ServletActionContext.getRequest().getParameter("tId") != null) {
				setTaskId(Integer.parseInt(ServletActionContext.getRequest()
						.getParameter("tId")));
			} else {
				setTaskId(0);
			}

			HttpSession session = request.getSession();
			setUserId((Integer) session.getAttribute("uId"));
			setUserRole((Integer) session.getAttribute("uR"));

			// 所有任务
			ArrayList<Plan> pList = null;

			pList = (ArrayList<Plan>) pDAO.doSelectBytId(getTaskId(),
					getUserId());

			// 所有员工
			ArrayList<Task> tList = (ArrayList<Task>) tDAO
					.doSelectById(0, 0);

			request.setAttribute("tList", tList);
			session.setAttribute("pList", pList);

			retMess = "ShowPlanList";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;

	}

	// 显示计划列表
	public String NewPlan() throws Exception {
		PlanDAO pDAO = null;
		String retMess = "NewPlanFailed";

		try {
			pDAO = DAOFactory.getPlanDAOInstance();
			Plan plan = new Plan();

			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			setUserId((Integer) session.getAttribute("uId"));

			plan.setpName(getPlanName());
			plan.setpDescription(getPlanDescription());
			plan.setpBeginDate(getPlanBeginDate());
			plan.setpEndDate(getPlanEndDate());
			plan.setTask_tId(getTaskId());
			plan.setUser_uId(getUserId());

			System.out.println(plan);

			if (pDAO.doInsertTask(plan)) {
				retMess = "NewPlan";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;

	}
}
