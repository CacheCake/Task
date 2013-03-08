package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.interfaces.UserDAO;
import dao.utils.DAOFactory;

public class SignInAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userId;
	private String userPwd;
	private int userRole;

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

	// µÇÂ½servlet
	public String DoSignIn() throws Exception {
		UserDAO uDAO;
		String retMess = "SignInFailed";
		try {
			uDAO = DAOFactory.getUserDAOInstance();
			if (uDAO.doSelectForSignIn(getUserId(), getUserPwd())) {
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
		}
		return retMess;
	}
}
