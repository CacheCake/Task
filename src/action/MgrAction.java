package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Task;

import org.apache.struts2.ServletActionContext;

import dao.interfaces.TaskDAO;
import dao.utils.DAOFactory;

public class MgrAction {

	private int taskId;
	private int userId;
	private int userRole;
	private String taskStatus;

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

	// 显示任务列表
	public String ShowTaskList() throws Exception {
		TaskDAO tDAO = null;
		String retMess = "ShowTaskListFailed";

		try {
			tDAO = DAOFactory.getTaskDAOInstance();

			HttpServletRequest request = ServletActionContext.getRequest();

			HttpSession session = request.getSession();
			setUserId((Integer) session.getAttribute("uId"));

			setUserRole((Integer) session.getAttribute("uR"));
			ArrayList<Task> tList = null;
			System.out.println("role:" + getUserRole());
			if (getUserRole() == 0) {
				tList = (ArrayList<Task>) tDAO.doSelectById(0, 0);
			} else {
				tList = (ArrayList<Task>) tDAO.doSelectById(0, getUserId());
			}

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

			HttpServletRequest request = ServletActionContext.getRequest();
			setTaskId(Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("tId")));

			HttpSession session = request.getSession();
			setUserId((Integer) session.getAttribute("uId"));

			if (tDAO.doUpdateStatusToDone(getTaskId())) {
				ArrayList<Task> tList = (ArrayList<Task>) tDAO.doSelectById(0,
						getUserId());

				session.setAttribute("tList", tList);

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

				HttpServletRequest request = ServletActionContext.getRequest();
				setTaskId(Integer.parseInt(ServletActionContext.getRequest()
						.getParameter("tId")));

				HttpSession session = request.getSession();
				setUserId((Integer) session.getAttribute("uId"));

				if (tDAO.doUpdateStatusToCollect(getTaskId())) {
					ArrayList<Task> tList = (ArrayList<Task>) tDAO.doSelectById(0,
							getUserId());

					session.setAttribute("tList", tList);

					retMess = "TaskCollect";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return retMess;

		}
}
