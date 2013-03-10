package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
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
	private String userName;
	private String userPwd1;
	private String userPwd2;
	private String userRole;
	private String userGender;
	private String userPosition;
	private String userProfessional;
	private String userExprience;
	private String userMgr;
	private String userEducation;
	private String error;

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPwd1() {
		return userPwd1;
	}

	public void setUserPwd1(String userPwd1) {
		this.userPwd1 = userPwd1;
	}

	public String getUserPwd2() {
		return userPwd2;
	}

	public void setUserPwd2(String userPwd2) {
		this.userPwd2 = userPwd2;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public String getUserProfessional() {
		return userProfessional;
	}

	public void setUserProfessional(String userProfessional) {
		this.userProfessional = userProfessional;
	}

	public String getUserExprience() {
		return userExprience;
	}

	public void setUserExprience(String userExprience) {
		this.userExprience = userExprience;
	}

	public String getUserMgr() {
		return userMgr;
	}

	public void setUserMgr(String userMgr) {
		this.userMgr = userMgr;
	}

	public String getUserEducation() {
		return userEducation;
	}

	public void setUserEducation(String userEducation) {
		this.userEducation = userEducation;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	// 显示员工列表
	public String ShowMemberList() throws Exception {
		UserDAO uDAO = null;
		String retMess = "ShowMemberListFailed";

		try {
			uDAO = DAOFactory.getUserDAOInstance();
			ArrayList<User> uList = (ArrayList<User>) uDAO.doSelectById(0);
			// 注册Session
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("uList", uList);

			return "ShowMemberList";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;

	}

	// 新增成员
	public String InsertMember() throws Exception {
		UserDAO uDAO = null;
		String retMess = "NewFailed";

		try {
			uDAO = DAOFactory.getUserDAOInstance();

			User user = new User();
			user.setuName(getUserName());
			if (getUserPwd1().equals(getUserPwd2())) {
				user.setuPwd(getUserPwd1());
			} else {
				setError("201");
				return retMess;
			}
			user.setuGender(getUserGender());
			user.setuRole(getUserRole());
			user.setuPosition(getUserPosition());
			user.setuExprience(getUserExprience());
			user.setuProfessional(getUserProfessional());
			user.setuMgr(getUserMgr());
			user.setuEducation(getUserEducation());

			if (uDAO.doInsertMember(user)) {
				return "NewSuccess";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;
	}

	// 显示成员详细
	public String ShowMember() throws Exception {
		UserDAO uDAO = null;
		String retMess = "ShowMemberFailed";

		try {
			uDAO = DAOFactory.getUserDAOInstance();
			// 获得uId
			setUserId(Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("uId")));

			ArrayList<User> uList = (ArrayList<User>) uDAO
					.doSelectById(getUserId());

			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("uList", uList);

			ArrayList<String> mgrList = (ArrayList<String>) uDAO
					.doSelectAllMgr(getUserId());
			request.setAttribute("mgrList", mgrList);

			retMess = "ShowMember";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;
	}

	// 显示新建成员
	public String ShowNewMember() throws Exception {
		UserDAO uDAO = null;
		String retMess = "ShowMemberFailed";

		try {
			uDAO = DAOFactory.getUserDAOInstance();

			ArrayList<String> mgrList = (ArrayList<String>) uDAO
					.doSelectAllMgr(0);

			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("mgrList", mgrList);

			retMess = "ShowMember";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;
	}

	// 修改成员信息
	public String UpdateMember() throws Exception {
		UserDAO uDAO = null;
		String retMess = "UpdateMemberFailed";

		try {
			uDAO = DAOFactory.getUserDAOInstance();
			User user = new User();
			// 获得uId
			setUserId(Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("uId")));

			user.setuId(getUserId());
			user.setuMgr(getUserMgr());
			user.setuEducation(getUserEducation());

			if (uDAO.doUpdateMember(user)) {
				ArrayList<User> uList = (ArrayList<User>) uDAO
						.doSelectById(getUserId());

				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("uList", uList);

				ArrayList<String> mgrList = (ArrayList<String>) uDAO
						.doSelectAllMgr(getUserId());
				request.setAttribute("mgrList", mgrList);

				retMess = "UpdateMember";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;

	}
}