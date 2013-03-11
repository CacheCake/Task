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

	// 显示任务列表
	public String ShowTaskList() throws Exception {
		TaskDAO tDAO = null;
		String retMess = "ShowTaskListFailed";

		try {
			tDAO = DAOFactory.getTaskDAOInstance();

			HttpServletRequest request = ServletActionContext.getRequest();

			HttpSession session = request.getSession();
			setUserId((Integer) session.getAttribute("uId"));

			ArrayList<Task> tList = (ArrayList<Task>) tDAO.doSelectById(0,
					getUserId());
			// 注册Session

			session.setAttribute("tList", tList);

			retMess = "ShowTaskList";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;

	}
}
