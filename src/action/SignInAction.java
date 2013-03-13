package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.interfaces.UserDAO;
import dao.utils.DAOFactory;

public class SignInAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userId;
	private String userPwd;
	private int userRole;
	private HttpServletRequest request;

	public int getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = Integer.parseInt(userId);
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = Integer.parseInt(userRole);
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	// µÇÂ½
	public String DoSignIn() throws Exception {
		UserDAO uDAO = null;
		String retMess = "SignInFailed";
		try {
			uDAO = DAOFactory.getUserDAOInstance();
			System.out.println(getUserRole());
			if (uDAO.doSelectForSignIn(getUserId(), getUserPwd(), getUserRole())) {

				ArrayList<User> uList = new ArrayList<User>();
				uList = (ArrayList<User>) uDAO.doSelectById(getUserId());
				// ×¢²áSession
				HttpSession session = request.getSession();
				session.setAttribute("uList", uList);
				session.setAttribute("uRole", getUserRole());
			
				session.setAttribute("uId", getUserId());

				switch (getUserRole()) {
				case 1:
					retMess = "HRSignInSuccess";
					break;
				case 2:
					retMess = "MgrSignInSuccess";
					break;
				case 3:
					retMess = "StfSignInSuccess";
					break;
				default:
					retMess = "SignInFailed";
					break;
				}
			} else {
				retMess = "SignInFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				uDAO.closeDBC3();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return retMess;
	}

	// ÍË³ö
	public String DoSignOut() throws Exception {
		String retMess = "SignOutFailed";
		try {
			// ×¢ÏúSession
			HttpSession session = request.getSession();
			session.invalidate();
			System.out.println(session);
			retMess = "SignOutSuccess";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMess;
	}

}
