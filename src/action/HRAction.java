package action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import model.User;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.interfaces.UserDAO;
import dao.utils.DAOFactory;

public class HRAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = Integer.parseInt(userId);
	}

	// ��ʾԱ���б�
	public String ShowMemberList() throws Exception {
		UserDAO uDAO = null;
		String retMess = "ShowMemberListFailed";

		try {
			uDAO = DAOFactory.getUserDAOInstance();
			ArrayList<User> uList = (ArrayList<User>) uDAO.doSelectById(0);
			// ע��Session
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("uList", uList);

			return "ShowMemberList";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;

	}

	// ������Ա
	public String NewMember() throws Exception {
		UserDAO uDAO = null;
		String retMess = "NewFailed";

		try {
			uDAO = DAOFactory.getUserDAOInstance();
			

			return "NewSuccess";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;
	}
}