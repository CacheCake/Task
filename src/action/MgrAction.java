package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Task;

import org.apache.struts2.ServletActionContext;

import dao.interfaces.TaskDAO;
import dao.interfaces.UserDAO;
import dao.utils.DAOFactory;

public class MgrAction {

	private int taskId;
	private int userId;
	private int userRole;
	private String taskStatus;
	private String taskName;
	private String taskDescription;
	private String taskBeginDate;
	private String taskEndDate;
	private String user_uMgr;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

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

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskBeginDate() {
		return taskBeginDate;
	}

	public void setTaskBeginDate(String taskBeginDate) {
		this.taskBeginDate = taskBeginDate;
	}

	public String getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(String taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public String getUser_uMgr() {
		return user_uMgr;
	}

	public void setUser_uMgr(String user_uMgr) {
		this.user_uMgr = user_uMgr;
	}

	// 显示任务列表
	public String ShowTaskList() throws Exception {
		TaskDAO tDAO = null;
		UserDAO uDAO = null;
		String retMess = "ShowTaskListFailed";

		try {
			tDAO = DAOFactory.getTaskDAOInstance();
			uDAO = DAOFactory.getUserDAOInstance();

			HttpServletRequest request = ServletActionContext.getRequest();

			HttpSession session = request.getSession();
			setUserId((Integer) session.getAttribute("uId"));
			setUserRole((Integer) session.getAttribute("uR"));

			// 所有任务
			ArrayList<Task> tList = null;
			System.out.println("role:" + getUserRole());
			if (getUserRole() == 0) {
				tList = (ArrayList<Task>) tDAO.doSelectById(0, 0);
			} else {
				tList = (ArrayList<Task>) tDAO.doSelectById(0, getUserId());
			}

			// 所有主管
			ArrayList<String> mgrList = (ArrayList<String>) uDAO
					.doSelectAllMgr(getUserId());

			request.setAttribute("mgrList", mgrList);
			session.setAttribute("tList", tList);

			retMess = "ShowTaskList";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;

	}

	// 完成任务
	public String TaskDone() throws Exception {
		TaskDAO tDAO = null;
		String retMess = "TaskDoneFailed";

		try {
			tDAO = DAOFactory.getTaskDAOInstance();

			setTaskId(Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("tId")));

			if (tDAO.doUpdateStatusToDone(getTaskId())) {
				retMess = "TaskDone";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;

	}

	// 归档
	public String TaskCollect() throws Exception {
		TaskDAO tDAO = null;
		String retMess = "TaskCollectFailed";

		try {
			tDAO = DAOFactory.getTaskDAOInstance();

			setTaskId(Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("tId")));

			if (tDAO.doUpdateStatusToCollect(getTaskId())) {
				retMess = "TaskCollect";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;

	}

	// 新建
	public String NewTask() throws Exception {
		TaskDAO tDAO = null;
		String retMess = "NewTaskFailed";

		try {
			tDAO = DAOFactory.getTaskDAOInstance();
			Task task = new Task();

			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			setUserId((Integer) session.getAttribute("uId"));

			task.settName(getTaskName());
			task.settDescription(getTaskDescription());
			task.settBeginDate(getTaskBeginDate());
			task.settEndDate(getTaskEndDate());
			task.setUser_uId(getUserId());
			task.setUser_uMgr(getUser_uMgr());

			System.out.println(task);

			if (tDAO.doInsertTask(task)) {
				retMess = "NewTask";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;

	}

	// 修改
	public String UpdateTask() throws Exception {
		TaskDAO tDAO = null;
		String retMess = "UpdateTaskFailed";

		try {
			tDAO = DAOFactory.getTaskDAOInstance();
			Task task = new Task();

			setTaskId(Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("tId")));
			task.settId(getTaskId());
			task.settName(getTaskName());
			task.settDescription(getTaskDescription());
			task.setUser_uMgr(getUser_uMgr());

			System.out.println(task);

			if (tDAO.doUpdateTask(task)) {
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("top1", 1);
				System.out.println(session.getAttribute("top1"));

				retMess = "UpdateTask";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;

	}
}
