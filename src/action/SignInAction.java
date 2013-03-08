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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	// µÇÂ½servlet
	public String DoSignIn() throws Exception {
		UserDAO uDAO;
		try {
			uDAO = DAOFactory.getUserDAOInstance();
			if (uDAO.doSelectForSignIn(getUserId(), getUserPwd())) {
				System.out.println(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "SignInSuccess";
	}
}
